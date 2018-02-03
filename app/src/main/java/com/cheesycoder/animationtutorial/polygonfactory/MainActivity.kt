package com.cheesycoder.animationtutorial.polygonfactory

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatSeekBar
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewTreeObserver
import android.view.animation.AccelerateInterpolator
import android.widget.LinearLayout
import android.widget.SeekBar
import com.cheesycoder.animationtutorial.R
import com.cheesycoder.animationtutorial.entry.EntryActivity
import com.cheesycoder.animationtutorial.path_tracing.DotFollowingActivity


class MainActivity : AppCompatActivity() {
    companion object {
        const val SIDE_MAX = 8
        const val SIDE_MIN = 3

        const val CORNER_MAX = 50
        const val CORNER_MIN = 1

        const val PROGRESS_MAX = 20
        const val PROGRESS_STEP = 20F
    }

    private var sideSeekBar: AppCompatSeekBar? = null
    private var canvas: CustomView? = null
    private var cornerSeekBar: AppCompatSeekBar? = null
    private var progressSeekBar: AppCompatSeekBar? = null
    private lateinit var rootView: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title = "Polygon Factory"

        sideSeekBar = findViewById(R.id.angle_modifier)
        canvas = findViewById(R.id.canvas)
        cornerSeekBar = findViewById(R.id.corner_modifier)
        progressSeekBar = findViewById(R.id.progress_modifier)
        rootView = findViewById(R.id.root_view)
        val button = findViewById<AppCompatButton>(R.id.next_button)
        sideSeekBar?.max = SIDE_MAX
        cornerSeekBar?.max = CORNER_MAX
        progressSeekBar?.max = PROGRESS_MAX
        progressSeekBar?.progress = PROGRESS_MAX

        intent.apply {
            if (hasExtra(EntryActivity.POSITION_Y) && hasExtra(EntryActivity.POSITION_X)) {
                rootView.visibility = View.INVISIBLE
                val positionX = getFloatExtra(EntryActivity.POSITION_X, 0f)
                val positionY = getFloatExtra(EntryActivity.POSITION_Y, 0f)

                if (rootView.viewTreeObserver.isAlive) {
                    rootView.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                        override fun onGlobalLayout() {
                            revealActivity(positionX, positionY)
                            rootView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                        }
                    })
                }
            }
        }

        sideSeekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                canvas?.side = progress + SIDE_MIN
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        cornerSeekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                canvas?.cornerThickness = (progress + CORNER_MIN).toFloat()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
        progressSeekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                canvas?.progress = progress / PROGRESS_STEP
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        button.setOnClickListener {
            val intent = Intent(this@MainActivity, DotFollowingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun revealActivity(positionX: Float, positionY: Float) {
        val finalRadius = Math.hypot(positionX.toDouble(), positionY.toDouble()).toFloat()

        val anim = ViewAnimationUtils.createCircularReveal(rootView, positionX.toInt(), positionY.toInt(), 0f, finalRadius).apply {
            duration = 350
            interpolator = AccelerateInterpolator()
        }
        rootView.apply {
            visibility = View.VISIBLE
        }
        anim.start()
    }
}

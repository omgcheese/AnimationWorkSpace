package com.cheesycoder.animationtutorial.path_tracing

import android.animation.ObjectAnimator
import android.animation.ValueAnimator.INFINITE
import android.animation.ValueAnimator.RESTART
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.view.animation.LinearInterpolator
import com.cheesycoder.animationtutorial.R
import com.cheesycoder.animationtutorial.avd.AvdActivity

/**
 * Author: jinwo
 * Date: 2018-01-28
 * Package: com.cheesycoder.animationtutorial
 *
 *\      _..--'''@   @'''--.._
 *\    .'   @_/-//-\/>/>'/ @  '.
 *\   (  @  /_<//<'/----------^-)
 *\   |'._  @     //|',|}}}}}}}}|
 *\   |  ~   ~   |/ | *|./|{{{{{|
 *\    '._ ~ ~ ~ |,/`````````````
 *\       ''--.~.|/
 */
class DotFollowingActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dot_following)

        supportActionBar?.title = "Polygon Tracing"

        val multiPolygon = findViewById<MultiplePolygonsView>(R.id.multi_polygon_view)
        ObjectAnimator.ofFloat(multiPolygon, MultiplePolygonsView.DOT_PROGRESS, 0f, 1f).apply {
            duration = 20000L
            interpolator = LinearInterpolator()
            repeatCount = INFINITE
            repeatMode = RESTART
        }.start()

        val button: AppCompatButton = findViewById(R.id.to_avd_button)
        button.setOnClickListener {
            val intent = Intent(this@DotFollowingActivity, AvdActivity::class.java)
            startActivity(intent)
        }
    }
}
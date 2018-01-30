package com.cheesycoder.animationtutorial.avd

import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.cheesycoder.animationtutorial.R

/**
 * Author: jinwo
 * Date: 2018-01-28
 * Package: com.cheesycoder.animationtutorial.avd
 *
 *\      _..--'''@   @'''--.._
 *\    .'   @_/-//-\/>/>'/ @  '.
 *\   (  @  /_<//<'/----------^-)
 *\   |'._  @     //|',|}}}}}}}}|
 *\   |  ~   ~   |/ | *|./|{{{{{|
 *\    '._ ~ ~ ~ |,/`````````````
 *\       ''--.~.|/
 */
class AvdActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Using Render Thread"
        setContentView(R.layout.activity_avd_layout)
        val avdController = AvdController()
        findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(this@AvdActivity)
            adapter = avdController.adapter
        }
        avdController.buildIrrationalList()

        findViewById<AppCompatImageView>(R.id.avd_image).apply {
            val animatedDrawable = context.getDrawable(R.drawable.avd_image_asset)
            if (animatedDrawable is AnimatedVectorDrawable) {
                setImageDrawable(animatedDrawable)
                animatedDrawable.start()
            }
        }
    }
}
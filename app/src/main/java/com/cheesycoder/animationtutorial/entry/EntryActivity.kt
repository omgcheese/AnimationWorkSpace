package com.cheesycoder.animationtutorial.entry

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import android.widget.LinearLayout
import com.cheesycoder.animationtutorial.R
import com.cheesycoder.animationtutorial.avd.AvdActivity
import com.cheesycoder.animationtutorial.path_tracing.DotFollowingActivity
import com.cheesycoder.animationtutorial.polygonfactory.MainActivity

/**
 * Author: jinwo
 * Date: 2018-01-30
 * Package: com.cheesycoder.animationtutorial.entry
 *
 *\      _..--'''@   @'''--.._
 *\    .'   @_/-//-\/>/>'/ @  '.
 *\   (  @  /_<//<'/----------^-)
 *\   |'._  @     //|',|}}}}}}}}|
 *\   |  ~   ~   |/ | *|./|{{{{{|
 *\    '._ ~ ~ ~ |,/`````````````
 *\       ''--.~.|/
 */
class EntryActivity: AppCompatActivity(), EntryNavigationCallbacks {
    companion object {
        @JvmStatic val POSITION_X = "POSITION_X"
        @JvmStatic val POSITION_Y = "POSITION_Y"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Animation Examples"
        setContentView(R.layout.activity_entry)
        val controller = EntryController(this)
        findViewById<RecyclerView>(R.id.list).apply {
            layoutManager = LinearLayoutManager(this@EntryActivity)
            adapter = controller.adapter
        }
    }

    override fun onClickPolygonFactory(positionX: Float, positionY: Float, view: View) {
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, view, "transition")
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(POSITION_X, positionX)
        intent.putExtra(POSITION_Y, positionY)
        startActivity(intent, options.toBundle())
    }

    override fun onClickPathTracing() {
        startActivity(Intent(this, DotFollowingActivity::class.java))
    }

    override fun onClickAVD() {
        startActivity(Intent(this, AvdActivity::class.java))
    }
}
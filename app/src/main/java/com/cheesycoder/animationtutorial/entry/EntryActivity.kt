package com.cheesycoder.animationtutorial.entry

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
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

    override fun onClickPolygonFactory() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onClickPathTracing() {
        startActivity(Intent(this, DotFollowingActivity::class.java))
    }

    override fun onClickAVD() {
        startActivity(Intent(this, AvdActivity::class.java))
    }
}
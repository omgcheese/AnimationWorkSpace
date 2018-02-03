package com.cheesycoder.animationtutorial.entry

import android.view.View
import com.airbnb.epoxy.EpoxyController
import com.cheesycoder.animationtutorial.R
import com.cheesycoder.animationtutorial.avd.SimpleViewModel_

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
class EntryController(private val entryNavigationCallbacks: EntryNavigationCallbacks): EpoxyController() {
    private var touchX: Float = 0f
    private var touchY: Float = 0f
    init {
        requestModelBuild()
    }
    override fun buildModels() {
        EntryViewModel_()
                .id("Polygon Factory")
                .title("Polygon Factory")
                .body("Example of polygon creation. Sides, corners, and path length can be modified")
                .imageRes(R.drawable.polygon_factory)
                .onTouchEventListener(View.OnTouchListener { v, event ->
                    touchX = event.x
                    touchY = event.y
                    return@OnTouchListener false
                })
                .onClickNavigation(View.OnClickListener {
                    entryNavigationCallbacks.onClickPolygonFactory(touchX, touchY, it)
                })
                .addTo(this)

        EntryViewModel_()
                .id("Path Tracing")
                .title("Path Tracing")
                .body("Multiple polygons is drawn. Dots will be following corresponding path.")
                .imageRes(R.drawable.path_tracing)
                .onClickNavigation(View.OnClickListener {
                    entryNavigationCallbacks.onClickPathTracing()
                })
                .addTo(this)

        EntryViewModel_()
                .id("AVD")
                .title("AVD")
                .body("Example of Rendering Thread")
                .imageRes(R.drawable.avd)
                .onClickNavigation(View.OnClickListener {
                    entryNavigationCallbacks.onClickAVD()
                })
                .addTo(this)
    }
}
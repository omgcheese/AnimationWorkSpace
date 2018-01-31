package com.cheesycoder.animationtutorial.entry

import android.view.View
import com.airbnb.epoxy.EpoxyController
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
    init {
        requestModelBuild()
    }
    override fun buildModels() {
        SimpleViewModel_()
                .id("Polygon Factory")
                .simpleTextView("Polygon Factory")
                .onClickSimpleViewListener(View.OnClickListener {
                    entryNavigationCallbacks.onClickPolygonFactory()
                })
                .addTo(this)

        SimpleViewModel_()
                .id("Path Tracing")
                .simpleTextView("Path Tracing")
                .onClickSimpleViewListener(View.OnClickListener {
                    entryNavigationCallbacks.onClickPathTracing()
                })
                .addTo(this)

        SimpleViewModel_()
                .id("AVD")
                .simpleTextView("AVD")
                .onClickSimpleViewListener(View.OnClickListener {
                    entryNavigationCallbacks.onClickAVD()
                })
                .addTo(this)
    }
}
package com.cheesycoder.animationtutorial.entry

import android.view.View

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
interface EntryNavigationCallbacks {
    /**
     * Navigate to Polygon Factory [com.cheesycoder.animationtutorial.polygonfactory.MainActivity]
     */
    fun onClickPolygonFactory(positionX: Float, positionY: Float, view: View)

    /**
     * Navigate to Path Tracing [com.cheesycoder.animationtutorial.path_tracing.DotFollowingActivity]
     */
    fun onClickPathTracing()

    /**
     * Navigate to AVD [com.cheesycoder.animationtutorial.avd.AvdActivity]
     */
    fun onClickAVD()
}
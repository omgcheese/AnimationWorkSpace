package com.cheesycoder.animationtutorial.avd

import com.airbnb.epoxy.EpoxyController

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
class AvdController: EpoxyController() {

    fun buildIrrationalList() {
        requestModelBuild()
    }

    override fun buildModels() {
        for (i in 1..1000) {
            SimpleViewModel_()
                    .id(i)
                    .simpleTextView("This is Super simple View but 1000 of them")
                    .addTo(this)
        }
    }
}
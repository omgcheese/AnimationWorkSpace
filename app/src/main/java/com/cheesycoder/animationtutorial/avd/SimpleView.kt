package com.cheesycoder.animationtutorial.avd

import android.content.Context
import android.support.annotation.Nullable
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
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
@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class SimpleView @JvmOverloads constructor(
        context: Context,
        attributeSet: AttributeSet? = null,
        defStyle: Int = 0
) : LinearLayout(context, attributeSet, defStyle) {
    private val simpleTextView: AppCompatTextView
    init {
        orientation = VERTICAL
        LayoutInflater.from(context).inflate(R.layout.simple_text_view, this, true)

        simpleTextView = findViewById(R.id.simple_text_view)
    }

    @TextProp
    fun setSimpleTextView(text: CharSequence) {
        simpleTextView.text = text
    }

    @CallbackProp
    fun setOnClickSimpleViewListener(@Nullable onClickListener: OnClickListener?) {
       setOnClickListener(onClickListener)
    }
}
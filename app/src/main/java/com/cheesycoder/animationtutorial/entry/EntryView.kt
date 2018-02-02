package com.cheesycoder.animationtutorial.entry

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.annotation.Nullable
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cheesycoder.animationtutorial.R
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

/**
 * Author: jinwo
 * Date: 2018-01-31
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
@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class EntryView @JvmOverloads constructor(
        context: Context,
        attributeSet: AttributeSet? = null,
        defStyle: Int = 0
) : FrameLayout(context, attributeSet, defStyle){
    @BindView(R.id.image_entry)
    lateinit var imageEntry: AppCompatImageView

    @BindView(R.id.title)
    lateinit var title: AppCompatTextView

    @BindView(R.id.body)
    lateinit var body: AppCompatTextView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_entry, this, true)
        ButterKnife.bind(this)
    }

    @TextProp
    fun setTitle(text: CharSequence) {
        title.text = text
    }

    @TextProp
    fun setBody(text: CharSequence) {
        body.text = text
    }

    @ModelProp
    fun setImageRes(@DrawableRes drawableRes: Int) {
        Glide.with(this)
                .load(drawableRes)
                .apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(6, 0, RoundedCornersTransformation.CornerType.TOP)))
                .into(imageEntry)
    }

    @CallbackProp
    fun setOnClickNavigation(@Nullable onClickListener: OnClickListener?) {
        setOnClickListener(onClickListener)
    }
}
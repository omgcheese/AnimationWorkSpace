package com.cheesycoder.animationtutorial.path_tracing

import android.content.Context
import android.graphics.*
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.FloatProperty
import android.view.View
import com.cheesycoder.animationtutorial.R
import com.cheesycoder.animationtutorial.polygonfactory.CustomView

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
class MultiplePolygonsView @JvmOverloads constructor(
        context: Context,
        attributeSet: AttributeSet? = null,
        defStyle: Int = 0
) : View(context, attributeSet, defStyle) {
    var cornerThickness = 1f

    /**
     * Line Paint that will be traced
     * Contains CornerPathEffect to make good rounding
     */
    private val linePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 8f
        pathEffect = CornerPathEffect(cornerThickness)
    }

    /**
     * Creation of Dot
     *
     * Dot Path is kinda ambigious because it's really describing dot shape
     */
    val dotPath = Path().apply {
        addCircle(0f,0f, 14f, Path.Direction.CW)
    }

    private val dotPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = ContextCompat.getColor(context, android.R.color.background_dark)
        style = Paint.Style.FILL
        strokeWidth = 14f // Make sure stroke width is same as Circile Radius otherwise it will get cut off
    }

    val polygons = arrayListOf(
            CustomView.Polygon(3, 80f),
            CustomView.Polygon(4, 160f),
            CustomView.Polygon(5, 240f),
            CustomView.Polygon(6, 320f),
            CustomView.Polygon(7, 400f),
            CustomView.Polygon(8, 480f),
            CustomView.Polygon(9, 560f)
    )

    val colors = arrayListOf(
            ContextCompat.getColor(context, R.color.colorAccent),
            ContextCompat.getColor(context, R.color.polygon1),
            ContextCompat.getColor(context, R.color.polygon2),
            ContextCompat.getColor(context, R.color.polygon3),
            ContextCompat.getColor(context, R.color.polygon4),
            ContextCompat.getColor(context, R.color.polygon5),
            ContextCompat.getColor(context, R.color.polygon6)
    )

    var dotProgress = 0f
        set(value) {
            field = value.coerceIn(0f, 1f)
            invalidate()
        }


    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        for ((index, polygon) in polygons.withIndex()) {
            linePaint.color = colors[index]
            canvas?.drawPath(polygon.path, linePaint)
        }
        for ((index, polygon) in polygons.withIndex()) {
            val phase = dotProgress * polygon.length * (9 - index) // 9 - index represent the phase. starting at different phases
            /*
                [dotPath] represents dot to be drawn (shape) aka Stamp
                [polygon.length] Gap in-between Stamps (Making this as Full length of polygon makes one stamp
                [phase] Start-distance of first stamp. If phase is same for all polygons, they all start at same postion (change this to constant to see the effects
                [PathDashPathEffect.Style.TRANSLATE] Translating stamps to different position. There are more style like Morph or Rotate
             */
            dotPaint.pathEffect = PathDashPathEffect(dotPath, polygon.length, phase, PathDashPathEffect.Style.TRANSLATE)

            /*
                draw Dots along with [polygon.path]
             */
            canvas?.drawPath(polygon.path, dotPaint)
        }
    }

    object DOT_PROGRESS : FloatProperty<MultiplePolygonsView>("dotProgress") {
        override fun setValue(`object`: MultiplePolygonsView?, value: Float) {
            `object`?.dotProgress = value
        }

        override fun get(`object`: MultiplePolygonsView?): Float? {
            return `object`?.dotProgress
        }
    }
}
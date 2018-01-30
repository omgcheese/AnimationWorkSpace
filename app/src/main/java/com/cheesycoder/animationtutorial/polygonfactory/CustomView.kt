package com.cheesycoder.animationtutorial.polygonfactory

import android.content.Context
import android.graphics.*
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.Log
import android.view.View
import com.cheesycoder.animationtutorial.R

/**
 * Author: jinwo
 * Date: 2018-01-27
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
class CustomView @JvmOverloads constructor(context: Context, attributeSet: AttributeSet? = null, defStyle: Int = 0): View(context, attributeSet, defStyle) {
    companion object {
        private const val width = 1080
        private const val height = 1080
        private const val cx = (width / 2).toFloat()
        private const val cy = (height / 2).toFloat()
        private val pathMeasure = PathMeasure()
    }

    var progress = 1f
        set(value) {
            Log.d("Progress", "$value")
            field = value
            invalidate()
        }

    var side = 3
        set(value) {
            field = value
            polygon = Polygon(sides = value, radius = 200f)
        }
    var cornerThickness = 1f
        set(value) {
            field = value
            invalidate()
        }
    private var polygon = Polygon(sides = 3, radius = 200f)
        set(value) {
            field = value
            invalidate()
        }

    private val linePaint = Paint(ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 4f
        pathEffect = CornerPathEffect(cornerThickness)
        color = ContextCompat.getColor(context, R.color.colorAccent)
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        val dashEffect = DashPathEffect(
                floatArrayOf(progress * polygon.length, (1f - progress) * polygon.length),
                0f
        )
        linePaint.pathEffect = ComposePathEffect(dashEffect, CornerPathEffect(cornerThickness))

        canvas?.drawPath(polygon.path, linePaint)
    }

    class Polygon(val sides: Int, radius: Float) {
        val path = createPath(sides, radius)
        val length by lazy(LazyThreadSafetyMode.NONE) {
            pathMeasure.setPath(path, false)
            pathMeasure.length
        }

        fun createPath(sides: Int, radius: Float): Path {
            val path = Path()
            val angle = 2.0 * Math.PI / sides
            Log.d("DRAW", "Starting Coordinate X ${cx + (radius * Math.cos(0.0)).toFloat()}")
            Log.d("DRAW", "Starting Coordinate Y ${cy + (radius * Math.sin(0.0)).toFloat()}")
            path.moveTo(
                    cx + (radius * Math.cos(0.0)).toFloat(),
                    cy + (radius * Math.sin(0.0)).toFloat()
            )
            for (i in 1 until sides) {
                Log.d("DRAW", "Cos Angle ${Math.cos(angle * i)}")
                Log.d("DRAW", "Sine Angle ${Math.sin(angle * i)}")
                Log.d("DRAW", "Distance X ${radius * Math.cos(angle * i)}")
                Log.d("DRAW", "Distance Y ${radius * Math.sin(angle * i)}")
                Log.d("DRAW", "Coordinate X ${cx + (radius * Math.cos(angle * i)).toFloat()}")
                Log.d("DRAW", "Coordinate Y ${cy + (radius * Math.sin(angle * i)).toFloat()}")
                path.lineTo(
                        cx + (radius * Math.cos(angle * i)).toFloat(),
                        cy + (radius * Math.sin(angle * i)).toFloat()
                )
            }
            path.close()
            return path
        }
    }
}
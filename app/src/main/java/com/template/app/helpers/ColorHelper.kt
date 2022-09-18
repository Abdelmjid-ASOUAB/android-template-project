package com.template.app.helpers

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import androidx.core.content.ContextCompat

class ColorHelper {
    companion object {
        fun getColorFromAttribute(attrId: Int, context: Context): Int {
            val typedValue = TypedValue()
            val theme = context.theme
            theme.resolveAttribute(attrId, typedValue, true)
            return typedValue.data
        }

        fun getColor(colorId: Int, context: Context): Int {
            return ContextCompat.getColor(
                context,
                colorId
            )
        }

        fun parseRgbaHex(rgbaHex: String): Int {
            var colorValue = rgbaHex.replace("#", "")
            if (colorValue.length < 8) {
                return Color.parseColor(
                    rgbaHex
                )
            }
            val r = colorValue.substring(colorValue.length - 2)
            colorValue = r + colorValue.substring(0, colorValue.length - 2)
            return Color.parseColor("#$colorValue")
        }
    }
}
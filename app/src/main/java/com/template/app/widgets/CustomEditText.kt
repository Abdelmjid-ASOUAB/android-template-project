package com.template.app.widgets

import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.template.app.R
import com.template.app.localization.Localization

class CustomEditText(context: android.content.Context, attrs: AttributeSet) : AppCompatEditText(
    context,
    attrs
) {
    init {
        val localization = Localization(context)
        val values = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView)
        val fontWeight = values.getString(R.styleable.CustomTextView_customFontWeight)
        val font: Typeface? = localization.getFonType(context, fontWeight!!)
        this.typeface = font
    }
}
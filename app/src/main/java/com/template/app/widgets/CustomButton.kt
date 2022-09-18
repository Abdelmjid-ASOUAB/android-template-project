package com.template.app.widgets

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import com.google.android.material.button.MaterialButton
import com.template.app.R
import com.template.app.localization.Localization

class CustomButton(context: Context, attrs: AttributeSet) : MaterialButton(
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
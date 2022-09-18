package com.youcan.pay.widgets

import android.graphics.Typeface
import android.util.AttributeSet
import com.youcan.pay.R
import com.youcan.pay.localization.Localization

class CustomTextView : androidx.appcompat.widget.AppCompatTextView {
    constructor(context: android.content.Context, attrs: AttributeSet) : super(
        context,
        attrs
    ) {

        val localization = Localization(context)
        val values = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView)
        val fontWeight = values.getString(R.styleable.CustomTextView_customFontWeight)

        val font: Typeface? = localization.getFonType(context, fontWeight!!)
        this.typeface = font
    }
}

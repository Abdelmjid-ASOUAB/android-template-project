package com.template.app.widgets

import android.app.Activity
import android.graphics.Typeface
import com.google.android.material.snackbar.Snackbar
import com.kishandonga.csbx.CustomSnackbar
import com.template.app.R
import com.template.app.enums.FontWeight
import com.template.app.helpers.ColorHelper
import com.template.app.localization.Localization

class CustomSnackBar(private val activity: Activity) {
    private var customSnackBar: CustomSnackbar = CustomSnackbar(activity)
    private var localization: Localization = Localization(activity)
    private var typeface: Typeface = this.localization.getFonType(this.activity, FontWeight.BOLD.value)!!

    init {
        this.customSnackBar.padding(15)
        this.customSnackBar.cornerRadius(20f)
        this.customSnackBar.duration(Snackbar.LENGTH_LONG)
    }

    fun error(message: String) {
        customSnackBar.message(message)
        customSnackBar.textTypeface(this.typeface)
        customSnackBar.backgroundColor(ColorHelper.getColor(R.color.error, this.activity))
        customSnackBar.show()
    }

    fun success(message: String) {
        customSnackBar.message(message)
        customSnackBar.textTypeface(this.typeface)
        customSnackBar.backgroundColor(ColorHelper.getColor(R.color.success, this.activity))
        customSnackBar.show()
    }

    fun warning(message: String) {
        customSnackBar.message(message)
        customSnackBar.textTypeface(this.typeface)
        customSnackBar.textColor(ColorHelper.getColor(R.color.black, this.activity))
        customSnackBar.backgroundColor(ColorHelper.getColor(R.color.warning, this.activity))
        customSnackBar.show()
    }
}
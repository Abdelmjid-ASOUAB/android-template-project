package com.template.app.localization

import android.content.Context
import android.content.res.Configuration
import android.graphics.Typeface
import androidx.core.content.res.ResourcesCompat
import com.template.app.R
import com.template.app.enums.FontWeight
import com.template.app.enums.SharedPreferenceKeys
import com.youcan.pay.sharedPreference.SharedPreference
import java.util.*

class Localization(context: Context) {
    private val context: Context
    private var preference: SharedPreference
    private val supportedLang = listOf("en", "ar", "fr")

    init {
        this.context = context
        this.preference = SharedPreference(context)
    }


    fun setLocale(locale: String = "en") {
        this.preference.putObject(SharedPreferenceKeys.APP_LOCAL_KEY.value, locale)
        updateLocaleSetting()
    }

    fun getLocale(): String {
        var lang: String =
            this.preference.getObject(SharedPreferenceKeys.APP_LOCAL_KEY.value, String::class.java)
        if (!this.supportedLang.contains(lang)) {
            lang = "en"
        }

        return lang
    }

    fun updateLocaleSetting() {
        val lang = getLocale()
        val locale = Locale(lang, "MA")
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        this.context.resources.updateConfiguration(
            config,
            this.context.resources.displayMetrics
        )
    }

    fun getFonType(
        context: Context?,
        fontWeight: String = FontWeight.BOLD.value
    ): Typeface? {
        val locale = getLocale()

        val font: Typeface? = when (fontWeight) {
            FontWeight.REGULAR.value -> if (locale == "ar") ResourcesCompat.getFont(
                context!!,
                R.font.font_regular
            ) else ResourcesCompat.getFont(
                context!!, R.font.font_regular
            )
            FontWeight.MEDIUM.value -> if (locale == "ar") ResourcesCompat.getFont(
                context!!,
                R.font.font_medium
            ) else ResourcesCompat.getFont(
                context!!, R.font.font_medium
            )
            FontWeight.SEMI_BOLD.value -> if (locale == "ar") ResourcesCompat.getFont(
                context!!,
                R.font.font_semi_bold
            ) else ResourcesCompat.getFont(
                context!!, R.font.font_semi_bold
            )
            FontWeight.BOLD.value -> if (locale == "ar") ResourcesCompat.getFont(
                context!!,
                R.font.font_semi_bold
            ) else ResourcesCompat.getFont(
                context!!, R.font.font_semi_bold
            )

            FontWeight.LIGHT.value -> if (locale == "ar") ResourcesCompat.getFont(
                context!!,
                R.font.font_light
            ) else ResourcesCompat.getFont(
                context!!, R.font.font_light
            )
            else -> throw IllegalStateException("Unexpected value: $fontWeight")
        }

        return font
    }
}
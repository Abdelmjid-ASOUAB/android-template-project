package com.template.app.enums

import android.content.res.Resources

enum class SharedPreferenceKeys(val value: String) {
    SHEARED_FILE_NAME(""),
    LOGGED_KEY("logged"),
    APP_LOCAL_KEY("app_local"),
    FIRST_USE_KEY("first_use");

    companion object {
        fun valueOf(value: String): SharedPreferenceKeys {
            return values()
                .firstOrNull { it.value == value }
                ?: throw Resources.NotFoundException("Could not find Key with value: $value")
        }
    }
}
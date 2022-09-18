package com.template.app.enums

import android.content.res.Resources

enum class FontWeight(val value: String) {
    REGULAR("0"),
    MEDIUM("1"),
    SEMI_BOLD("2"),
    BOLD("3"),
    LIGHT("4");

    companion object {
        fun valueOf(value: String): FontWeight {
            return FontWeight.values()
                .firstOrNull { it.value == value }
                ?: throw Resources.NotFoundException("Could not find font with value: $value")
        }
    }
}
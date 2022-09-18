package com.template.app.helpers

import java.text.SimpleDateFormat
import java.util.*

class DateHelper {
    companion object {
        fun getFormattedDate(timestamp: Long): String {
            val formatter = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())

            return formatter.format(Date(timestamp))
        }
    }
}
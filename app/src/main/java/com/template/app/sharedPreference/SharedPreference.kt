package com.youcan.pay.sharedPreference

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.google.gson.Gson
import com.template.app.enums.SharedPreferenceKeys
import java.lang.reflect.Type

class SharedPreference(context: Context) {
    private val gson = Gson()
    private val prefs: SharedPreferences
    private val editor: SharedPreferences.Editor

    init {
        prefs = context.getSharedPreferences(SharedPreferenceKeys.SHEARED_FILE_NAME.value, MODE_PRIVATE)
        editor = prefs.edit()
    }

    fun putObject(
        key: String?,
        `object`: Any?
    ) {
        editor.putString(key, gson.toJson(`object`))
        editor.apply()
        editor.commit()
    }

    fun <T> getObject(
        key: String?,
        typeOfT: Type?
    ): T {
        val json = prefs.getString(key, "")
        return gson.fromJson(json, typeOfT)
    }

    fun putInt(
        key: String?,
        value: Int
    ) {
        editor.putInt(key, value)
        editor.apply()
        editor.commit()
    }

    fun getInt(
        key: String?,
        defaultValue: Int
    ): Int {
        return prefs.getInt(key, defaultValue)
    }

    fun putBoolean(
        key: String?,
        value: Boolean
    ) {
        editor.putBoolean(key, value)
        editor.apply()
        editor.commit()
    }

    fun getBoolean(
        key: String?,
        defaultValue: Boolean
    ): Boolean {
        prefs.all
        return prefs.getBoolean(key, defaultValue)
    }

    fun putFloat(
        key: String?,
        value: Float
    ) {
        editor.putFloat(key, value)
        editor.apply()
        editor.commit()
    }

    fun getFloat(
        key: String?,
        defaultValue: Float
    ): Float {
        prefs.all
        return prefs.getFloat(key, defaultValue)
    }

    fun contains(
        key: String?
    ): Boolean {
        return prefs.contains(key)
    }

    fun count(): Int {
        return prefs.all.size
    }

    fun getAll(): Map<String?, *>? {
        return prefs.all
    }
}
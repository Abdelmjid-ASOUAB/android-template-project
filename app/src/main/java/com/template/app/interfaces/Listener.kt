package com.template.app.interfaces

interface Listener<T> {
    fun onResult(result: T)
}
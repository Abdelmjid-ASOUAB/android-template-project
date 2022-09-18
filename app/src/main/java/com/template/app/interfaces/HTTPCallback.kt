package com.template.app.interfaces

import com.template.app.models.HTTPResponse

interface HTTPCallback {
    fun onSuccess(result: HTTPResponse)
    fun onError(error: String?)
}
package com.template.app.models

import com.google.gson.annotations.SerializedName
import com.template.app.models.pagenation.Meta

data class HTTPGenericResponse<T>(
    val success: Boolean,
    val message: String,
    val statusCode: Int,
    @SerializedName("data")
    val element: T?,
    val elements: List<T>?,
    val meta: Meta?
)
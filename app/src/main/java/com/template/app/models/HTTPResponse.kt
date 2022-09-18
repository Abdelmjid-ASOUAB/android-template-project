package com.template.app.models

data class HTTPResponse(
    val success: Boolean,
    val statusCode: Int,
    val body: String?
)
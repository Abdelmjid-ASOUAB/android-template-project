package com.template.app.networking

import com.template.app.interfaces.HTTPCallback

abstract class HTTPAdapter {
    var httpCallback: HTTPCallback? = null

    abstract fun get(
        url: String,
        headers: HashMap<String, String>,
    )

    abstract fun post(
        url: String,
        headers: HashMap<String, String>,
        body: HashMap<String, String>,
    )

}
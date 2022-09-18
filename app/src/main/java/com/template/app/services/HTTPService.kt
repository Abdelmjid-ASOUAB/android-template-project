package com.template.app.services

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.template.app.interfaces.HTTPCallback
import com.template.app.models.HTTPGenericResponse
import com.template.app.networking.HTTPAdapter
import com.template.app.networking.RetrofitHTTPAdapter


abstract class HTTPService<T>(
    val context: Context,
) : HTTPCallback {
    val responseLiveData: MutableLiveData<HTTPGenericResponse<T>> = MutableLiveData()
    val httpAdapter: HTTPAdapter

    init {
        httpAdapter = RetrofitHTTPAdapter(this.context)
        httpAdapter.httpCallback = this
    }
}

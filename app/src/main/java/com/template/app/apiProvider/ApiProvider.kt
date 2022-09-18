package com.template.app.apiProvider

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ApiProvider {
    @POST
    fun post(
        @Url endpoint: String,
        @Body params: HashMap<String, String>,
        @HeaderMap header: HashMap<String, String>
    ): Call<ResponseBody>?

    @GET
    fun get(
        @Url endpoint: String,
        @HeaderMap header: HashMap<String, String>
    ): Call<ResponseBody>?
}
package com.template.app.networking

import android.content.Context
import com.template.app.apiProvider.ApiProvider
import com.template.app.configs.Constant
import com.template.app.models.HTTPResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHTTPAdapter(
    context: Context
) : HTTPAdapter(), Callback<ResponseBody> {
    private var retrofit: Retrofit? = null
    private var aPiProvider: ApiProvider

    init {
        aPiProvider = getClient().create(ApiProvider::class.java)
    }

    private fun initRetrofit() {
        retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getClient(): Retrofit {
        if (retrofit == null) {
            initRetrofit()
        }

        return retrofit!!
    }

    override fun get(
        url: String,
        headers: HashMap<String, String>,
    ) {
        aPiProvider.get(endpoint = url, header = headers)?.enqueue(this)
    }

    override fun post(
        url: String,
        headers: HashMap<String, String>,
        body: HashMap<String, String>,
    ) {
        aPiProvider.post(endpoint = url, header = headers, params = body)?.enqueue(this)
    }

    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
        var responseBody: String? = ""

        responseBody = if (response.isSuccessful) {
            response.body()?.string()
        } else {
            response.errorBody()?.string()
        }

        val httpResponse = HTTPResponse(
            success = response.isSuccessful,
            body = responseBody,
            statusCode = response.code()
        )

        httpCallback?.onSuccess(result = httpResponse)
    }

    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
        httpCallback?.onError(error = t.message)
    }

}
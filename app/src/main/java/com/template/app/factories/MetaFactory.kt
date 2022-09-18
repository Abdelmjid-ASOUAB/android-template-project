package com.template.app.factories

import com.google.gson.Gson
import com.template.app.interfaces.Transformer
import com.template.app.models.HTTPGenericResponse
import com.template.app.models.HTTPResponse
import com.template.app.models.pagenation.Meta

import org.json.JSONObject

class MetaFactory : Transformer<Meta> {

    override fun objectFromJson(json: String): Meta {
        val jsonObject = JSONObject(json)

        return Gson().fromJson(jsonObject.toString(), Meta::class.java)
    }

    override fun listFromJson(json: String): List<Meta> {
        return emptyList()
    }

    override fun responseFromJson(response: HTTPResponse, isList: Boolean): HTTPGenericResponse<Meta> {
        return HTTPGenericResponse(
            success = response.success,
            statusCode = response.statusCode,
            element = null,
            message = "",
            elements = listOf(),
            meta = null
        )
    }
}
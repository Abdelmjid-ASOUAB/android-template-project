package com.template.app.interfaces

import com.template.app.models.HTTPGenericResponse
import com.template.app.models.HTTPResponse


interface Transformer<T> {
    /**
     * Transform the response from the json to the model
     *
     * @param String the json model
     * @return the T model
     */
    fun objectFromJson(json: String): T

    /**
     * Transform the response from the json to the model
     *
     * @param String the json model
     * @return the List<T> model
     */
    @Throws(Exception::class)
    fun listFromJson(json: String): List<T>

    /**
     * Transform the response from the response to the model
     *
     * @param HTTPResponse the response model from the server
     * @return the HTTPGenericResponse<T> model
     */
    @Throws(Exception::class)
    fun responseFromJson(response: HTTPResponse, isList: Boolean = false): HTTPGenericResponse<T>
}
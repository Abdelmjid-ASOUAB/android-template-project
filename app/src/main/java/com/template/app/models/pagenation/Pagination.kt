package com.template.app.models.pagenation

import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("per_page")
    val perPage: Int,
    val total: Int,
    val count: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("current_page")
    val currentPage: Int,
)
package com.junianto.covcare.model.news


import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("data")
    var data: List<NewsData>,
    @SerializedName("length")
    var length: Int?,
    @SerializedName("status")
    var status: Int?
)
package com.junianto.covcare.model


import com.google.gson.annotations.SerializedName

data class NewsData(
    @SerializedName("judul")
    var judul: String?,
    @SerializedName("link")
    var link: String?,
    @SerializedName("poster")
    var poster: String?,
    @SerializedName("tipe")
    var tipe: String?,
    @SerializedName("waktu")
    var waktu: String?
)
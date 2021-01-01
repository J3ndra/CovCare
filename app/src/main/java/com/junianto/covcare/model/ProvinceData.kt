package com.junianto.covcare.model


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProvinceData(
    @SerializedName("fid")
    @Expose
    var fid: String?,
    @SerializedName("kasusMeni")
    @Expose
    var kasusMeni: String?,
    @SerializedName("kasusPosi")
    @Expose
    var kasusPosi: String?,
    @SerializedName("kasusSemb")
    @Expose
    var kasusSemb: String?,
    @SerializedName("kodeProvi")
    @Expose
    var kodeProvi: String?,
    @SerializedName("provinsi")
    @Expose
    var provinsi: String?
): Parcelable
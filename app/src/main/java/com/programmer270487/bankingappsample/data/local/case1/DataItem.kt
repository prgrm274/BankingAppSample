package com.programmer270487.bankingappsample.data.local.case1

import com.google.gson.annotations.SerializedName

data class DataItem(
    @SerializedName("Title")
    val title: String,
    val alt: String,
    val count: Int,
    @SerializedName("created_at")
    val createdAt: String,
    val desc: String,
    @SerializedName("desc_promo")
    val descPromo: Any,
    val id: Int,
    val img: Img,
    val latitude: String,
    val lokasi: String,
    val longitude: String,
    val nama: String,
    @SerializedName("name_promo")
    val namePromo: Any,
    @SerializedName("published_at")
    val publishedAt: String,
    @SerializedName("updated_at")
    val updatedAt: String
)
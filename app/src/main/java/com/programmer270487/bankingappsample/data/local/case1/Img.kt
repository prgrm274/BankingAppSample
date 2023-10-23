package com.programmer270487.bankingappsample.data.local.case1

import com.google.gson.annotations.SerializedName

data class Img(
    val alternativeText: String,
    val caption: String,
    @SerializedName("created_at")
    val createdAt: String,
    val ext: String,
    val formats: Formats,
    val hash: String,
    val height: Int,
    val id: Int,
    val mime: String,
    val name: String,
    val previewUrl: Any,
    val provider: String,
    @SerializedName("provider_metadata")
    val providerMetadata: Any,
    val size: Double,
    @SerializedName("updated_at")
    val updatedAt: String,
    val url: String,
    val width: Int
)
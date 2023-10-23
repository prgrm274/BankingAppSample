package com.programmer270487.bankingappsample.data.remote.case2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIService {
    private const val BASE_URL = "https://content.digi46.id/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val promoService: PromoService by lazy {
        retrofit.create(PromoService::class.java)
    }
}

package com.programmer270487.bankingappsample.data.remote.case2

import com.programmer270487.bankingappsample.data.local.case1.Data
import retrofit2.http.GET

interface PromoService {
    @GET("promos")
    suspend fun getPromos(): Data
}
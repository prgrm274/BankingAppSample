package com.programmer270487.bankingappsample.data.remote.case2

import com.programmer270487.bankingappsample.data.local.case1.Data
import retrofit2.http.GET
import retrofit2.http.Headers

interface PromoService {
    @GET("promos")
    // https://content.digi46.id/promos still 404 with or without authorization
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwiaWF0IjoxNjc1OTE0MTUwLCJleHAiOjE2Nzg1MDYxNTB9.TcIgL5CDZYg9o8CUsSjUbbUdsYSaLutOWni88ZBs9S8") // Add your Bearer token here
    suspend fun getPromos(): Data
}
package com.programmer270487.bankingappsample.data.local.case3

import com.google.gson.annotations.SerializedName

data class Transaction(
    @SerializedName("trx_date")
    val trxDate: String,
    val nominal: Double
)

data class PortfolioData(
    val type: String,
    val data: Any?
)

data class DonutChartData(
    val label: String,
    val percentage: String,
    val data: List<Transaction>?
)

data class LineChartData(
    val month: List<Int>
)
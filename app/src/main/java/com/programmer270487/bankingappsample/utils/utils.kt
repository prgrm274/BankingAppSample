package com.programmer270487.bankingappsample.utils

import android.content.Context
import com.google.gson.Gson
import com.programmer270487.bankingappsample.data.local.case3.DonutChartData
import com.programmer270487.bankingappsample.data.local.case3.LineChartData
import com.programmer270487.bankingappsample.data.local.case3.PortfolioData
import com.programmer270487.bankingappsample.data.local.case3.Transaction

fun readJsonFile(context: Context, fileName: String): String {
    val json: String
    try {
        val inputStream = context.assets.open(fileName)
        json = inputStream.bufferedReader().use { it.readText() }
    } catch (e: Exception) {
        e.printStackTrace()
        return ""
        json = "" // Set a default value for json in case of an error
    }
    return json
}

/**
 * For case in json that has different type of property eg:
 * [ { "data": [AN ARRAY]}, { "data": {AN OBJECT} } ]]
 */
fun parseJsonToPortfolioDataWithDiffType(json: String): List<DonutChartData> {
    val gson = Gson()
    // donutChart or lineChart
    val portfolioDataList = gson.fromJson(json, Array<PortfolioData>::class.java).toList()
    var donutChartDataList = mutableListOf<DonutChartData>()

    for (portfolioData in portfolioDataList) {

        if (portfolioData.type == "donutChart") {

            if (portfolioData.data is List<*>) {
                val mapList = portfolioData.data as List<Map<String, Any>>
                for (map in mapList) {
                    val label = map["label"] as String
                    val percentage = map["percentage"] as String
                    val nestedData = map["data"] as List<Map<String, Any>>

                    val transactions = nestedData.map {
                        Transaction(
                            it["trx_date"] as String,
                            it["nominal"] as Double
                        )
                    }

                    donutChartDataList.add(DonutChartData(label, percentage, transactions))
                }
            } else if (portfolioData.data is Map<*, *>) {
                // Handle the case where data is an object (may need to create a DonutChartData from the object)
            }
        }/* else if (portfolioData.type == "lineChart") {

            // Handle LineChartData
            val lineChartData =
                gson.fromJson(gson.toJson(portfolioData.data), LineChartData::class.java)
            // Proses LineChartData
            lineChartData.month.forEach { _ ->

            }
            val lineChartDataList = lineChartData.month
            donutChartDataList.add(DonutChartData("Line Chart", "100", lineChartDataList.map {
                Transaction(
                    "", // Hanya meminjam properti data class Transaction, tidak pengaruh ke data Line Chart
                    it.toDouble()
                )
            }))
        }*/
    }
    return donutChartDataList
}

/**
 * Only to handle lineChart to be shown
 */
fun parseLineChartJson(json: String): LineChartData? {
    val gson = Gson()
    val portfolioDataList = gson.fromJson(json, Array<PortfolioData>::class.java).toList()
    var months = mutableListOf<Int>()

    for (portfolioData in portfolioDataList) {
        if (portfolioData.type == "lineChart") {
            return gson.fromJson(gson.toJson(portfolioData.data), LineChartData::class.java)

            /*lineChartData.month.forEach {
                months.add(it)
            }*/


            /*list.add(DonutChartData("Line Chart", "100", lineChartDataList.map {
                Transaction(
                    "", // Hanya meminjam properti data class Transaction, tidak pengaruh ke data Line Chart
                    it.toDouble()
                )
            }))*/
        }
    }
    return null
}

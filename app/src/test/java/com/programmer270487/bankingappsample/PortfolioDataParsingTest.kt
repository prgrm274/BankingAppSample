package com.programmer270487.bankingappsample

import com.google.gson.Gson
import com.programmer270487.bankingappsample.data.local.case3.DonutChartData
import com.programmer270487.bankingappsample.data.local.case3.Transaction
import com.programmer270487.bankingappsample.utils.parseJsonToPortfolioDataWithDiffType
import org.junit.Assert.assertEquals
import org.junit.Test

class PortfolioDataParsingTest { // passed

    @Test
    fun testParseJsonToPortfolioDataWithDiffType() {
        val json = """
            [
                {
                    "type": "donutChart",
                    "data": [
                        {
                            "label": "Label 1",
                            "percentage": "30",
                            "data": [
                                {
                                    "trx_date": "01/01/2023",
                                    "nominal": 1000.0
                                },
                                {
                                    "trx_date": "02/01/2023",
                                    "nominal": 1500.0
                                }
                            ]
                        },
                        {
                            "label": "Label 2",
                            "percentage": "70",
                            "data": [
                                {
                                    "trx_date": "01/01/2023",
                                    "nominal": 500.0
                                }
                            ]
                        }
                    ]
                },
                {
                    "type": "lineChart",
                    "data": {
                        "month": [3, 7, 8, 10, 5, 10, 1, 3, 5, 10, 7, 7]
                    }
                }
            ]
        """.trimIndent()

        val expectedDonutChartDataList = listOf(
            DonutChartData(
                "Label 1",
                "30",
                listOf(
                    Transaction("01/01/2023", 1000.0),
                    Transaction("02/01/2023", 1500.0)
                )
            ),
            DonutChartData(
                "Label 2",
                "70",
                listOf(
                    Transaction("01/01/2023", 500.0)
                )
            )
        )

        val actualDonutChartDataList = parseJsonToPortfolioDataWithDiffType(json)

        // Assert that the actual result matches the expected result
        assertEquals("Tes equals", expectedDonutChartDataList, actualDonutChartDataList)
    }
}

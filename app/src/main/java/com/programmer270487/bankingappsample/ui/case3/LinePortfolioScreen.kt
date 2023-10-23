package com.programmer270487.bankingappsample.ui.case3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.programmer270487.bankingappsample.data.local.case3.DonutChartData
import com.programmer270487.bankingappsample.data.local.case3.LineChartData

@Composable
fun LinePortfolioScreen(
    lineChartData: LineChartData?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Line Chart Frekuensi Bulan")

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 40.dp)) {
//            LineChartView(lineChartData!!)
            LineChart(lineChartData!!)
        }
    }
}
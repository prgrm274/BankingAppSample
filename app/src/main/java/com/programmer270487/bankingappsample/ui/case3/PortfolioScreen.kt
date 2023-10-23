package com.programmer270487.bankingappsample.ui.case3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.programmer270487.bankingappsample.data.local.case3.DonutChartData

@Composable
fun PortfolioScreen(
    portfolioData: List<DonutChartData>,
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        portfolioData.forEach { data ->
            val color = when (data.label) {
                "Tarik Tunai" -> Color.Red
                "QRIS Payment" -> Color.Gray
                "Topup Gopay" -> Color.Green
                "Lainnya" -> Color.Blue
                else -> Color.Black // Warna default jika label tidak sesuai dengan yang diharapkan
            }
            Text(
                text = "${data.label}: ${data.percentage}%",
                style = TextStyle(fontSize = 16.sp, color = color)
            )
        }

        // Tampilkan data portofolio dalam bentuk chart
        DonutChart(portfolioData)
    }
}
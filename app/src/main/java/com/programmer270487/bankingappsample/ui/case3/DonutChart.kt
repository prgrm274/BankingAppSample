package com.programmer270487.bankingappsample.ui.case3

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.programmer270487.bankingappsample.data.local.case3.DonutChartData

@Composable
fun DonutChart(data: List<DonutChartData>) {
    Canvas(modifier = Modifier
        .height(400.dp)
        .fillMaxWidth()) {
        val centerX = size.width / 2
        val centerY = size.height / 2
        val radius = size.minDimension / 4

        var startAngle = 0f

        data.forEach { entry ->
            val sweepAngle = entry.percentage.toFloat() * 3.6f
            val endAngle = startAngle + sweepAngle

            val color = when (entry.label) {
                "Tarik Tunai" -> Color.Red
                "QRIS Payment" -> Color.Gray
                "Topup Gopay" -> Color.Green
                "Lainnya" -> Color.Blue
                else -> Color.Black // Warna default jika label tidak sesuai dengan yang diharapkan
            }

            drawArc(
                color = color,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = false,
                topLeft = Offset(centerX - radius, centerY - radius),
                size = Size(radius * 2, radius * 2),
                style = Stroke(width = radius)
            )

            startAngle = endAngle
        }
    }
}

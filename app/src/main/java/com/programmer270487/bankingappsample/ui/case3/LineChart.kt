package com.programmer270487.bankingappsample.ui.case3

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.asComposePaint
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import com.programmer270487.bankingappsample.data.local.case3.LineChartData

/*@Composable
fun LineChart(lineChartData: LineChartData) {
    val data = lineChartData.month

    Canvas(
        modifier = Modifier.fillMaxWidth().height(300.dp)
    ) {
        val maxX = data.size.toFloat()
        val maxY = data.maxOrNull()?.toFloat() ?: 1f
        val scaleX = size.width / maxX
        val scaleY = size.height / maxY

        val path = Path()
        val paint = Paint().apply {
            color = Color.Red // Warna teks
//            style = 28F // Ukuran teks
        }

        for (i in data.indices) {
            val x = i.toFloat() * scaleX
            val y = size.height - data[i].toFloat() * scaleY

            if (i == 0) {
                path.moveTo(x, y)
            } else {
                path.lineTo(x, y)
            }

            // Menggambar label bulan pada posisi yang sesuai
            drawContext.canvas.nativeCanvas.drawText(
                getMonthLabel(i),
                x,
                size.height,
                paint.asFrameworkPaint()
            )
        }

        drawPath(path = path, color = Color.Blue, style = Stroke(width = 2f))
    }
}*/

@Composable
fun LineChart(lineChartData: LineChartData) {
    val data = lineChartData.month

    Canvas(
        modifier = Modifier.fillMaxWidth().height(300.dp)
    ) {
        val maxX = data.size.toFloat()
        val maxY = data.maxOrNull()?.toFloat() ?: 1f
        val scaleX = size.width / maxX
        val scaleY = size.height / maxY

        val path = Path()
        val paint = Paint().asComposePaint().apply {
            color = Color.Red // Warna teks
        }
//        val paint = Paint().apply {
//            color = android.graphics.Color.parseColor("#000") // Warna teks
//            textAlign = Paint.Align.CENTER
//            textSize = 28F // Ukuran teks
//        }

        for (i in data.indices) {
            val x = i.toFloat() * scaleX
            val y = size.height - data[i].toFloat() * scaleY

            if (i == 0) {
                path.moveTo(x, y)
            } else {
                path.lineTo(x, y)
            }

            // Menggambar label bulan pada posisi yang sesuai
//            drawContext.canvas.drawText( // compose paint
//                getMonthLabel(i),
//                x,
//                size.height,
//                paint
//            )

            // Menggambar label bulan pada posisi yang sesuai
            drawContext.canvas.nativeCanvas.drawText( // android paint
                getMonthLabel(i),
                x,
                size.height,
//                paint // android Paint
                paint.asFrameworkPaint() // compose Paint as android Paint
            )
        }

        drawPath(path = path, color = Color.Blue, style = Stroke(width = 2f))
    }
}

fun getMonthLabel(index: Int): String {
    val monthLabels =
        arrayOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
    return monthLabels.getOrNull(index) ?: ""
}

/**
 * Tanpa label
 */
@Composable
fun LineChartView(
    lineChartData: LineChartData
) {
    val intList = lineChartData.month

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        val maxX = intList.size.toFloat()
        val maxY = intList.maxOrNull()?.toFloat() ?: 1f
        val scaleX = size.width / maxX
        val scaleY = size.height / maxY

        val path = Path()
            .apply {}

        for (i in intList.indices) {
            val x = i.toFloat() * scaleX
            val y = size.height - intList[i].toFloat() * scaleY

            if (i == 0) {
                path.moveTo(x, y)
            } else {
                path.lineTo(x, y)
            }
        }

        drawPath(path = path, color = Color.Blue, style = Stroke(width = 2f))
    }

    /*Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        lineChartData.forEach {
            val data = it.month

            val dataPoints = data.size

            // Menghitung lebar setiap bar
            val barWidth = canvasWidth / dataPoints

            // Menghitung skala untuk tinggi garis
            val maxDataValue = data.maxOrNull() ?: 1
            val scaleY = canvasHeight / maxDataValue

            // Menggambar garis berdasarkan data
            for (i in 0 until dataPoints - 1) {
                val startX = i * barWidth
                val startY = canvasHeight - data[i] * scaleY
                val endX = (i + 1) * barWidth
                val endY = canvasHeight - data[i + 1] * scaleY

                drawLine(
                    color = Color.Blue,
                    start = Offset(startX, startY),
                    end = Offset(endX, endY),
                    strokeWidth = 4f // ketebalan garis
                )
            }
        }
    }*/
}

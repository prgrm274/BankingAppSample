package com.programmer270487.bankingappsample.ui.case2

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.programmer270487.bankingappsample.data.local.case1.DataItem

@Composable
fun PromoDetail(promo: DataItem, onClose: () -> Unit) {
    // Komponen untuk menampilkan detail promo
    // Implementasi tampilan detail promo
    // onClose adalah fungsi untuk menutup tampilan detail promo

    // Contoh tombol untuk menutup detail promo
    Button(onClick = onClose) {
        Text(text = "Tutup")
    }
}
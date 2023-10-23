package com.programmer270487.bankingappsample.ui.case2

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.programmer270487.bankingappsample.data.local.case1.DataItem

@Composable
fun PromoDetail(promo: DataItem, onClose: () -> Unit) {
    // Komponen untuk menampilkan detail promo
    // Implementasi tampilan detail promo
    // onClose adalah fungsi untuk menutup tampilan detail promo

    // Contoh tombol untuk menutup detail promo
    Button(onClick = onClose, Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)) {
        Text(text = promo.nama)
        Text(text = promo.desc, Modifier.padding(top = 10.dp))
    }
}
package com.programmer270487.bankingappsample.ui.case2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.programmer270487.bankingappsample.data.local.case1.DataItem

@Composable
fun PromoApp() {
    var promos by remember { mutableStateOf(emptyList<DataItem>()) } //Promo
    var selectedPromo by remember { mutableStateOf<DataItem?>(null) }

    // Lakukan panggilan ke API menggunakan Retrofit
    // Anda harus mengelola pemanggilan jaringan dengan baik

    // Buat ViewModel atau gunakan repository untuk melakukan pemanggilan jaringan
    val viewModel: PromoViewModel = viewModel()

    // Menggunakan LaunchedEffect untuk menjalankan pemanggilan API sekali saat komponen pertama kali dibuat
    LaunchedEffect(Unit) {
        viewModel.loadPromos()
    }

    // Pengamatan perubahan data promos
    val promoListState by viewModel.promoListState.collectAsState()

    when (promoListState) {
        is PromoListState.Loading -> {
            // Tampilkan indikator loading di sini jika diperlukan
            Text("Loading...")
            CircularProgressIndicator(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp))
        }

        is PromoListState.Success -> {
            // Ketika pemanggilan API berhasil, perbarui daftar promo
            promos = (promoListState as PromoListState.Success).promos
            PromoList(promos = promos) {
                selectedPromo = it
            }
//            PromoList(promos, onPromoClick)
//            PromoList(promos)

            selectedPromo?.let { promo ->
                PromoDetail(promo = promo) {
                    selectedPromo = null
                }
            }
        }

        is PromoListState.Error -> {
            // Tampilkan pesan kesalahan di sini jika diperlukan
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "ERROR promo\n\n${(promoListState as PromoListState.Error).message}",
                    fontSize = 24.sp,
                    color = Color.Red
                )
            }
        }
    }
}

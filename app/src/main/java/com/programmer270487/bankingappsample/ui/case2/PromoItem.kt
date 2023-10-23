package com.programmer270487.bankingappsample.ui.case2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.programmer270487.bankingappsample.data.local.case1.DataItem
import com.programmer270487.bankingappsample.ui.utils.getFormattedLocation
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun PromoItem(promo: DataItem, onClick: () -> Unit) {//promo: Promo
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surface)
            .clickable { onClick() } // Memberikan efek klik
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // IMG
            val imageUrl = promo.img.formats.small.url // Sesuaikan dengan format gambar yang Anda inginkan
            if (!imageUrl.isNullOrBlank()) {
                // Border hijau dengan corner rounded
                /*val borderModifier = Modifier
                    .border(2.dp, Color.Green, RoundedCornerShape(8.dp))
                    .clip(RoundedCornerShape(8.dp))*/
                GlideImage(
                    model = promo.img.url,
                    contentDescription = "getString(R.id.picture_of_cat)",
                    /*modifier = borderModifier.then(Modifier
                        .fillMaxWidth()
                        .height(200.dp) // Atur tinggi gambar sesuai kebutuhan
                    ),*/
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                )
            }

            // NAMA
            Text(
                text = promo.nama ?: "Nama Tidak Tersedia",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))

            // DESC
            Text(
                text = promo.desc ?: "Deskripsi Tidak Tersedia",
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(8.dp))

            val dateFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale("id", "ID"))
            val publishedAt = dateFormatter.parse(promo.updatedAt)
//            val createdAt = dateFormatter.parse(promo.createdAt)

            Text(
                text = "Dipublikasikan pada: ${SimpleDateFormat("dd MMMM yyyy, HH:mm", Locale("id", "ID")).format(publishedAt)}",
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            /*Text(
                text = "Dibuat pada: ${SimpleDateFormat("dd MMMM yyyy", Locale("id", "ID")).format(createdAt)}",
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = promo.latitude ?: "Latitude Tidak Tersedia",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))*/

            Text(
                text = promo.lokasi ?: "Lokasi Tidak Tersedia",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))

            val latitude = promo.latitude.toDoubleOrNull()
            val longitude = promo.longitude.toDoubleOrNull()
            if (latitude != null && longitude != null) {
                Text(
                    text = "Koordinat: ${getFormattedLocation(latitude, longitude)}",
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}
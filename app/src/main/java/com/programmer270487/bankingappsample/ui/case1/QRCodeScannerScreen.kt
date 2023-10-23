package com.programmer270487.bankingappsample.ui.case1

import QRCodeScanner
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.text.NumberFormat
import java.util.Locale

@Composable
fun QRCodeScannerScreen() {
    var scannedQrCode by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (scannedQrCode == null) {
            // Display the QR code scanner
            QRCodeScanner { qrCode ->
                scannedQrCode = qrCode
            }
        } else {
            // Display the scanned QR code
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                val blocks = scannedQrCode!!.split('.')

                if (blocks.size >= 4) {
                    val bankSumber = blocks[0]
                    val idTransaksi = blocks[1]
                    val namaMerchant = blocks[2]
                    val nominalTransaksi = blocks[3]

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text("Bank Sumber")
                        Text(
                            bankSumber,
                            Modifier.fillMaxWidth().border(1.dp, Color.Green).padding(4.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("ID Transaksi")
                        Text(
                            idTransaksi,
                            Modifier.fillMaxWidth().border(1.dp, Color.Green).padding(4.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Nama Merchant")
                        Text(
                            namaMerchant,
                            Modifier.fillMaxWidth().border(1.dp, Color.Green).padding(4.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Nominal Transaksi")
                        val nominal = nominalTransaksi.toInt()
                        val formattedNominal =
                            NumberFormat.getCurrencyInstance(Locale("id", "ID")).format(nominal)
                        Text(
                            "Rp. $formattedNominal,-",
                            Modifier.fillMaxWidth().border(1.dp, Color.Green).padding(4.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Scanned QR Code: $scannedQrCode")
                    }
                } else {
                    Text("Format QR code tidak sesuai atau tidak lengkap")
                }
            }
        }
    }
}
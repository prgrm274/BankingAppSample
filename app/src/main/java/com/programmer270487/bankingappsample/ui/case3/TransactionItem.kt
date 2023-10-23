package com.programmer270487.bankingappsample.ui.case3

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.programmer270487.bankingappsample.data.local.case3.Transaction
import java.text.NumberFormat
import java.util.Locale

@Composable
fun TransactionItem(transaction: Transaction, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surface)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            val nominal = transaction.nominal.toInt()
            val formattedNominal = NumberFormat.getCurrencyInstance(Locale("id", "ID")).format(nominal)

            Text(text = "Tanggal: ${transaction.trxDate}, Nominal: Rp. $formattedNominal,-")
        }
    }
}
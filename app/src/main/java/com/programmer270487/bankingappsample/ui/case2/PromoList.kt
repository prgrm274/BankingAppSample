package com.programmer270487.bankingappsample.ui.case2

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.programmer270487.bankingappsample.data.local.case1.DataItem

@Composable
fun PromoList(promos: List<DataItem>, onPromoClick: (DataItem) -> Unit) {//promos: List<Promo>
    LazyColumn {
        items(promos) { promo ->
            PromoItem(promo, onClick = { onPromoClick(promo) })
        }
    }
}
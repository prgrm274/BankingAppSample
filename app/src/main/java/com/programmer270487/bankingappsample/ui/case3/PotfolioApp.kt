package com.programmer270487.bankingappsample.ui.case3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.programmer270487.bankingappsample.data.local.case3.DonutChartData
import com.programmer270487.bankingappsample.data.local.case3.Transaction

@Composable
fun PortfolioApp(
    navController: NavController,
    portfolioData: List<DonutChartData>,
) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    TabRow(selectedTabIndex) {
        Tab(
            selected = selectedTabIndex == 0,
            onClick = { selectedTabIndex = 0 }
        ) {
            Text(
                text = "Portfolio",
                Modifier
                    .background(Color.Cyan)
                    .padding(10.dp)
                    .fillMaxWidth()
            )
        }

        Tab(
            selected = selectedTabIndex == 1,
            onClick = { selectedTabIndex = 1 }
        ) {
            Text(
                text = "Detail Transaksi",
                Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .padding(10.dp)
                    .fillMaxWidth()
            )
        }
    }

    when (selectedTabIndex) {
        0 -> PortfolioScreen(portfolioData, navController)
        1 -> TransactionDetailScreen(portfolioData, navController)
    }
}

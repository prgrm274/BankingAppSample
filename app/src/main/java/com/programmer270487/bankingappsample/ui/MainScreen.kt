package com.programmer270487.bankingappsample.ui

import com.programmer270487.bankingappsample.ui.case1.QRCodeScannerScreen
import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.programmer270487.bankingappsample.R
import com.programmer270487.bankingappsample.data.local.case3.LineChartData
import com.programmer270487.bankingappsample.ui.case2.PromoApp
import com.programmer270487.bankingappsample.ui.case3.PortfolioApp
import com.programmer270487.bankingappsample.utils.parseJsonToPortfolioDataWithDiffType
import com.programmer270487.bankingappsample.utils.parseLineChartJson
import com.programmer270487.bankingappsample.utils.readJsonFile

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(context: Context) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val navController = rememberNavController()
    val json = readJsonFile(context, "json3.json")
    val donutChartData = parseJsonToPortfolioDataWithDiffType(json)
    val lineChartData = parseLineChartJson(json)

    Scaffold(
        bottomBar = {
            BottomNavigation {
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_comment_bank_24),
                            contentDescription = "Promo"
                        )
                    },
                    label = { Text("Promo") },
                    selected = selectedTabIndex == 0,
                    onClick = {
                        selectedTabIndex = 0
                        navController.navigate("promo")
                    }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_qr_code_scanner_24),
                            contentDescription = "Scan QR"
                        )
                    },
                    label = { Text("Scan QR") },
                    selected = selectedTabIndex == 1,
                    onClick = {
                        selectedTabIndex = 1
                        navController.navigate("scanqr")
                    }
                )
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_bar_chart_24),
                            contentDescription = "Portfolio"
                        )
                    },
                    label = { Text("Portfolio") },
                    selected = selectedTabIndex == 2,
                    onClick = {
                        selectedTabIndex = 2
                        navController.navigate("portfolio")
                    },
                )
            }
        }
    ) {
        NavHost(navController, startDestination = "promo") {
            composable("promo") {
                PromoApp()
            }
            composable("scanqr") {
                QRCodeScannerScreen()
            }
            composable("portfolio") {
                PortfolioApp(
                    navController,
                    portfolioData = donutChartData,
                    lineChartData
                )
            }
        }
    }
}
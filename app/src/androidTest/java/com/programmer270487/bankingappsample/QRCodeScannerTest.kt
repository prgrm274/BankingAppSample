package com.programmer270487.bankingappsample

import androidx.compose.ui.test.*
import QRCodeScanner
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class QRCodeScannerTest {

//    @get:Rule
//    val composeAndroidTestRule = createAndroidComposeRule<MainActivity>()
    @get:Rule
    private val composeTestRule = createComposeRule()

    @Test
    fun testQRCodeScanner() {
        val scannedQrCode = "BNI.ID12345678.MERCHANT MOCK TEST.50000" // Simulate scanned QR code

        composeTestRule.setContent {
            QRCodeScanner { qrCode ->
                // This will be called when a QR code is scanned
                assert(qrCode == scannedQrCode) // You can assert the expected result here
            }
        }

        // You can use UI tests to interact with your Composable here if needed
        // For example, you can use composeTestRule.onNodeWithTag("yourTag").performClick()
    }
}

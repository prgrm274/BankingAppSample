package com.programmer270487.bankingappsample

import com.programmer270487.bankingappsample.ui.case1.QRCodeScannerScreen
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.programmer270487.bankingappsample.ui.MainScreen
import com.programmer270487.bankingappsample.ui.theme.GridChartUITheme

class MainActivity : ComponentActivity() {
    private lateinit var cameraPermissionLauncher: ActivityResultLauncher<String>
    private var scannedQrCode: String? by mutableStateOf(null)
    private var isScanning by mutableStateOf(true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Request camera permission
        cameraPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                // Permission granted, proceed with QR code scanning
                scannedQrCode = null
                isScanning = true
            } else {
                // Permission denied, handle the denial or show a message
                Toast.makeText(this, "Camera permission denied. QR code scanning won't work.", Toast.LENGTH_SHORT).show()
            }
        }

        setContent {
            MaterialTheme {
                MainScreen(this)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GridChartUITheme {
        QRCodeScannerScreen()
    }
}

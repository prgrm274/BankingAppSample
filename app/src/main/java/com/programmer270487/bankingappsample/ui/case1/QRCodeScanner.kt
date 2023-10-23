import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.journeyapps.barcodescanner.BarcodeCallback
import com.journeyapps.barcodescanner.BarcodeResult
import com.journeyapps.barcodescanner.DecoratedBarcodeView

@Composable
fun QRCodeScanner(
    onQrCodeScanned: (String) -> Unit
) {
    val context = LocalContext.current
    val barcodeView = remember { DecoratedBarcodeView(context) }

    DisposableEffect(Unit) {
        barcodeView.barcodeView.cameraSettings.requestedCameraId = 0 // Rear camera
        barcodeView.decodeContinuous(object : BarcodeCallback {
            override fun barcodeResult(result: BarcodeResult?) {
                result?.text?.let {
                    onQrCodeScanned(it)
                }
            }
        })

        barcodeView.resume()

        onDispose {
            barcodeView.pause()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .border(1.dp, Color.White)
    ) {
        AndroidView({ barcodeView }, Modifier.matchParentSize())
    }
}


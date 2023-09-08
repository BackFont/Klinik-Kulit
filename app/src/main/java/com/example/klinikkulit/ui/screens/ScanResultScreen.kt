package com.example.klinikkulit.ui.screens

import android.graphics.Bitmap
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.klinikkulit.dummy.DummyProvider
import com.example.klinikkulit.ml.Model
import com.example.klinikkulit.models.Disease
import com.example.klinikkulit.ui.theme.Purple20
import com.example.klinikkulit.utils.AppText
import com.example.klinikkulit.utils.NavRoute
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import kotlin.reflect.KFunction0


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScanResultScreen(
    capturedImage: Bitmap,
    navController: NavHostController,
    onCapturedPhotoConsumed: KFunction0<Unit>
) {
    val capturedImageBitmap: ImageBitmap = remember { capturedImage.asImageBitmap() }
    val context = LocalContext.current
    val imageProcessor = ImageProcessor.Builder()
        .add(ResizeOp(224, 224, ResizeOp.ResizeMethod.BILINEAR))
//        .add(TransformToGrayscaleOp())
//        .add(NormalizeOp(0.0f, 255.0f))
        .build()
    var results by remember { mutableStateOf(Disease("", "", "", "", "")) }

    LaunchedEffect(Unit) {
        var tensorImage = TensorImage(DataType.FLOAT32)
        tensorImage.load(capturedImage)
        tensorImage = imageProcessor.process(tensorImage)

        val model = Model.newInstance(context)
// Creates inputs for reference.
        val inputFeature0 =
            TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)
        inputFeature0.loadBuffer(tensorImage.buffer)

// Runs model inference and gets result.
        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

        var maxIdx = 0
        var maxConfidence = 0f
        outputFeature0.forEachIndexed { index, fl ->
            if (outputFeature0[maxIdx] < fl) {
                maxConfidence = outputFeature0[maxIdx]
                maxIdx = index
            }
        }
        results = DummyProvider().diseaseList[maxIdx]
        Log.d("TAG", results.name)
// Releases model resources if no longer used.
        model.close()
    }

    Scaffold(
        topBar = { TopBar(navController, "Hasil Scan") },
        bottomBar = { ScanResultBottomBar() }
    ) {
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(it)
                .padding(horizontal = 25.dp)
        ) {
            Box(Modifier.fillMaxWidth(), Alignment.Center) {
                Image(
                    bitmap = capturedImageBitmap,
                    contentDescription = "Captured photo",
                    Modifier
                        .padding(17.dp)
                        .size(300.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp), Arrangement.Center) {
                Button(
                    onClick = {
                        onCapturedPhotoConsumed()
                        navController.navigate(NavRoute.CAMERA.name) {
                            popUpTo(NavRoute.HOME.name) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Purple20),
                    shape = RoundedCornerShape(7.dp)
                ) {
                    AppText("Ambil Foto", FontWeight.Medium, 18.sp)
                }
            }
            AppText(
                "Hasil Prediksi: ${results.name}", FontWeight.Bold, 18.sp,
                MaterialTheme.colorScheme.onSurface
            )
            Spacer(Modifier.height(8.dp))
            AppText(
                "Jenis      : ${results.type}", fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            AppText(
                "Status     : ${results.status}", fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            AppText(
                "Saran      : ${results.advice}", fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            AppText(
                "Deskripsi", FontWeight.Bold, 18.sp, modifier = Modifier.padding(vertical = 8.dp),
                color = MaterialTheme.colorScheme.onSurface
            )
            AppText(
                results.description, fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(Modifier.height(17.dp))
        }
    }
}

@Composable
fun ScanResultBottomBar() {
    Surface {
        Row(Modifier.fillMaxWidth(), Arrangement.Center) {
            Button(
                onClick = { /*TODO*/ }, Modifier.width(250.dp),
                colors = ButtonDefaults.buttonColors(Purple20),
                shape = RoundedCornerShape(7.dp)
            ) {
                AppText(
                    "Kembali ke Beranda", FontWeight.Medium, 18.sp,
                    Color.White, modifier = Modifier.padding(5.dp, 0.dp)
                )
            }
        }
    }

}
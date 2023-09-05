package com.example.klinikkulit.ui.screens

import android.content.Context
import android.graphics.Bitmap
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.klinikkulit.ml.Model
import com.example.klinikkulit.models.Disease
import com.example.klinikkulit.ui.theme.Purple20
import com.example.klinikkulit.utils.AppText
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.common.ops.NormalizeOp
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.image.ops.TransformToGrayscaleOp
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScanResultScreen(capturedImage: Bitmap, navController: NavHostController) {
    val capturedImageBitmap: ImageBitmap = remember { capturedImage.asImageBitmap() }
    val context = LocalContext.current
    val imageProcessor = ImageProcessor.Builder()
        .add(ResizeOp(224, 224, ResizeOp.ResizeMethod.BILINEAR))
        .add(TransformToGrayscaleOp())
        .add(NormalizeOp(0.0f, 255.0f))
        .build()
    val results by remember { mutableStateOf("") }

    Scaffold(topBar = { TopBar(navController, "Hasil Scan") }) {
        Column(Modifier.padding(it)) {
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
            Row(Modifier.padding(horizontal = 10.dp).fillMaxWidth(), Arrangement.SpaceAround) {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Purple20)
                ) {
                    AppText("Ambil Foto", FontWeight.Medium, 18.sp)
                }
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    border = BorderStroke(1.dp, Purple20)
                ) {
                    AppText("Scan Penyakit", FontWeight.Medium, 18.sp, Purple20)
                }
            }
            Text(results)
        }
    }
}

fun predictResults(context: Context, capturedImage: Bitmap, imageProcessor: ImageProcessor) {
    var tensorImage = TensorImage(DataType.UINT8)
    tensorImage.load(capturedImage)
    tensorImage = imageProcessor.process(tensorImage)

    val model = Model.newInstance(context)
// Creates inputs for reference.
    val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.FLOAT32)
    inputFeature0.loadBuffer(tensorImage.buffer)

// Runs model inference and gets result.
    val outputs = model.process(inputFeature0)
    val outputFeature0 = outputs.outputFeature0AsTensorBuffer.floatArray

    var maxIdx = 0
    var maxConfidence = 0f
    outputFeature0.forEachIndexed { index, fl ->
        if(outputFeature0[maxIdx] < fl) {
            maxConfidence = outputFeature0[maxIdx]
            maxIdx = index
        }
    }
    val diseaseList = listOf(
        Disease(
            "Actinic keratoses and intraepithelial carcinomae",
            "Bukan Melanoma",
            "Aman",
            "",
            ""
        )
    )
// Releases model resources if no longer used.
    model.close()
}
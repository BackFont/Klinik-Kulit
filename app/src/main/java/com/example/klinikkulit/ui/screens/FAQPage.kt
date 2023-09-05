package com.example.klinikkulit.ui.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.klinikkulit.R
import com.example.klinikkulit.models.Question
import com.example.klinikkulit.ui.theme.Purple50
import com.example.klinikkulit.utils.AppText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FAQPage(navController: NavHostController) {
    val questionsList = listOf(
        Question(
            "Apa itu kanker?",
            "Kanker adalah kondisi medis yang terjadi ketika sel-sel dalam tubuh mulai " +
                    "tumbuh secara tidak terkendali. Sel normal tumbuh dan berkembang dalam batas yang " +
                    "teratur, tetapi sel-sel kanker kehilangan kemampuan ini. " +
                    "Mereka terus membelah diri tanpa mengikuti kendali tubuh, " +
                    "membentuk massa jaringan yang disebut tumor. " +
                    "Tumor dapat bersifat ganas (kanker) atau jinak (non-kanker), " +
                    "tergantung pada sejauh mana mereka dapat menyebar ke jaringan di sekitarnya."
        ),
        Question("Apa itu kanker kulit?", ""),
        Question("Apakah kanker kulit berbahaya?", ""),
        Question("Apa perbedaan kanker kulit melanoma dan non-melanoma?", ""),
        Question("Bagaimana KlinikKulit bisa mendeteksi kanker kulit?", ""),
        Question("Apakah hasil deteksi KlinikKulit 100% akurat?", ""),
    )
    Scaffold(topBar = { TopBar(navController, "FAQ")}) {
        Column(Modifier.verticalScroll(rememberScrollState()).padding(it)) {
            Spacer(Modifier.height(10.dp))
            questionsList.forEach { question ->
                FAQCard(question)
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FAQCard(question: Question) {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 90f else 0f,
        label = ""
    )
    Card(
        onClick = { expandedState = !expandedState },
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(bottom = 10.dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = RoundedCornerShape(23.dp),
        colors = CardDefaults.cardColors(Purple50)
    ) {
        Column(Modifier.padding(start = 10.dp, end = 15.dp).padding(vertical = 10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(
                    onClick = { expandedState = !expandedState },
                    Modifier.rotate(rotationState)
                ) {
                    Icon(painterResource(R.drawable.arrow_right_bold), null,
                        tint = Color.White)
                }
                Spacer(Modifier.width(7.dp))
                AppText(question.questionTitle, FontWeight.ExtraBold, 20.sp)
            }
            if (expandedState) {
                AppText(question.answer, FontWeight.Medium, 16.sp,
                    modifier = Modifier.padding(start = 7.dp))
            }
        }
    }
}
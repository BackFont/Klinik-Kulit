package com.example.klinikkulit.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.klinikkulit.R
import com.example.klinikkulit.dummy.DummyProvider
import com.example.klinikkulit.ui.theme.Purple20
import com.example.klinikkulit.ui.theme.Purple40
import com.example.klinikkulit.ui.theme.Purple50
import com.example.klinikkulit.utils.AppText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticlesPage(navController: NavHostController) {
    val articlesList = DummyProvider().articlesList

    Scaffold(
        topBar = { TopBar(navController, "KlinikKulit") },
        bottomBar = { BottomBar(navController) }
    ) {
        Column(
            Modifier
                .padding(it)
                .verticalScroll(rememberScrollState())
        ) {
            Card(
                shape = RoundedCornerShape(14.dp),
                elevation = CardDefaults.cardElevation(5.dp),
                colors = CardDefaults.cardColors(Purple50),
                modifier = Modifier.padding(8.dp)
            ) {
                Row(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(8.dp)) {
                        AppText("Kanker Kulit,", FontWeight.ExtraBold, 25.sp)
                        AppText(
                            "Pahami jenis-jenis dan dampak kanker kulit",
                            FontWeight.Bold,
                            20.sp
                        )
                        Spacer(Modifier.height(20.dp))
                        AppText("Edukasi, Sains", fontSize = 11.sp)
                    }
                    Image(
                        painterResource(R.drawable.image_16), null,
                        Modifier.clip(RoundedCornerShape(23.dp)
                        )
                    )
                }
            }
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                AppText("Untukmu", FontWeight.Bold, 23.sp, MaterialTheme.colorScheme.onSurface)
                TextButton(onClick = { /*TODO*/ }) {
                    AppText(
                        "Selengkapnya", FontWeight.Medium, 14.sp,
                        Purple20, textDecoration = TextDecoration.Underline,
                    )
                }
            }
            Row {
                ArticleCard(articlesList[0])
                Spacer(Modifier.width(10.dp))
                ArticleCard(articlesList[1])
            }
            Row {
                ArticleCard(articlesList[2])
                Spacer(Modifier.width(10.dp))
                ArticleCard(articlesList[3])
            }
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                AppText("Untukmu", FontWeight.Bold, 23.sp, MaterialTheme.colorScheme.onSurface)
                TextButton(onClick = { /*TODO*/ }) {
                    AppText(
                        "Selengkapnya", FontWeight.Medium, 14.sp,
                        Purple20, textDecoration = TextDecoration.Underline,
                    )
                }
            }
        }
    }
}
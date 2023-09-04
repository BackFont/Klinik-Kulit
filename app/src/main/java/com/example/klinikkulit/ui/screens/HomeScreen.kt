package com.example.klinikkulit.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.klinikkulit.R
import com.example.klinikkulit.models.Article
import com.example.klinikkulit.ui.theme.Purple20
import com.example.klinikkulit.ui.theme.Purple50
import com.example.klinikkulit.utils.AppText
import com.example.klinikkulit.utils.NavRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val articlesList = listOf(
        Article("Mengenal Yayasan Kanker Indonesia, " +
                "Wadah Kepedulian Kanker masyarakat Indonesia", R.drawable.image_12
            )
    )
    Scaffold(topBar = { TopBar(navController, "Beranda") }, bottomBar = { BottomBar() }) {
        Column(
            Modifier
                .padding(it)
                .padding(horizontal = 15.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Card(Modifier.padding(vertical = 8.dp), RoundedCornerShape(23.dp),
                CardDefaults.cardColors(Purple50)) {
                Row(
                    Modifier
                        .padding(14.dp)
                        .fillMaxWidth(), Arrangement.SpaceBetween, Alignment.CenterVertically
                ) {
                    Column {
                        AppText("Selamat Datang!", FontWeight.ExtraBold, 27.sp)
                        AppText("Kylian Mbappe", FontWeight.Bold, 17.sp)
                    }
                    Spacer(Modifier.width(10.dp))
                    Row {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                painterResource(R.drawable.detect), null,
                                tint = MaterialTheme.colorScheme.background
                            )
                            Spacer(Modifier.height(2.dp))
                            AppText("Deteksi", FontWeight.Bold, 12.sp)
                        }
                        Spacer(Modifier.width(8.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                Icons.Default.History, null,
                                tint = MaterialTheme.colorScheme.background
                            )
                            AppText("Riwayat", FontWeight.Bold, 12.sp)
                        }
                    }
                }
            }
            Card(Modifier.padding(vertical = 8.dp), RoundedCornerShape(23.dp),
                CardDefaults.cardColors(Purple50)) {
                Column {
                    Box {
                        Column(Modifier.padding(top = 40.dp, start = 15.dp)) {
                            AppText(
                                "Bersama KlinikKulit,\nBerantas Kanker Kulit",
                                FontWeight.Bold, 20.sp
                            )
                            Spacer(Modifier.height(7.dp))
                            AppText(
                                "Kenali Bercak pada kulit anda,", FontWeight.Medium, 12.sp
                            )
                            AppText(
                                "Penanganan lebih awal dapat menyelamatkan nyawamu!",
                                FontWeight.Medium, 12.sp, modifier = Modifier.width(200.dp),
                                lineHeight = 14.sp
                            )
                        }
                        Box(Modifier.fillMaxWidth(), Alignment.CenterEnd) {
                            Image(painterResource(R.drawable.cancer), null,
                                Modifier.size(142.dp))
                        }
                    }
                    Spacer(Modifier.height(14.dp))
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        AppText("Bagaimana kasus kanker di dunia?", FontWeight.Medium, 16.sp)
                        Spacer(Modifier.height(10.dp))
                        Surface(
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 15.dp),
                            RoundedCornerShape(12.dp), border = BorderStroke(2.dp, Color.White),
                            color = Purple50
                        ) {
                            Row(
                                Modifier
                                    .padding(20.dp, 10.dp)
                                    .fillMaxWidth(), Arrangement.SpaceAround) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Icon(painterResource(R.drawable.virus), null)
                                    AppText("19 juta kasus kanker", fontSize = 8.sp)
                                    AppText("setiap tahun", fontSize = 8.sp)
                                }
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Icon(Icons.Default.Person, null,
                                        Modifier.size(32.dp), Color.White)
                                    AppText("7,9% kasus adalah", fontSize = 8.sp)
                                    AppText("kanker kulit", fontSize = 8.sp)
                                }
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Icon(painterResource(R.drawable.meninggoy), null,
                                        tint = Color.White)
                                    Spacer(Modifier.height(2.dp))
                                    AppText("120 ribu orang", fontSize = 8.sp)
                                    AppText("meninggal setiap tahun", fontSize = 8.sp)
                                }
                            }
                        }
                    }
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(35.dp, 15.dp), Arrangement.SpaceBetween) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            AppText("Kanker Kulit", fontSize = 11.sp)
                            AppText("Melanoma", FontWeight.Bold, 18.sp)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            AppText("Kanker Kulit", fontSize = 11.sp)
                            AppText("Non-Melanoma", FontWeight.Bold, 18.sp)
                        }
                    }
                }
            }
            Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                AppText("Untukmu", FontWeight.Bold, 23.sp, MaterialTheme.colorScheme.onSurface)
                TextButton(onClick = { /*TODO*/ }) {
                    AppText("Selengkapnya", FontWeight.Medium, 14.sp,
                        Purple20, textDecoration = TextDecoration.Underline,)
                }
            }
            Row(Modifier.padding(bottom = 20.dp)) {
                ArticleCard(articlesList[0])
            }
        }
    }
}

@Composable
fun TopBar(navController: NavHostController, title: String) {
    Surface(Modifier.fillMaxWidth(), color = Purple20) {
        Row(Modifier.padding(horizontal = 5.dp), Arrangement.SpaceBetween, Alignment.CenterVertically) {
            Image(painterResource(R.drawable.logo), null, Modifier.padding(5.dp, 4.dp))
            AppText(title, FontWeight.Bold, 18.sp)
            Row(Modifier.padding(end = 15.dp)) {
                IconButton(onClick = { navController.navigate(NavRoute.FAQ.name) }) {
                    Icon(painterResource(R.drawable.help), null, tint = Color.White)
                }
            }
        }
    }
}

@Composable
fun ArticleCard(article: Article) {
    Card(
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(Color.White),
        modifier = Modifier.width(200.dp)
        ) {
        Image(painterResource(article.image), null)
        AppText(text = article.title, FontWeight.Bold, 12.sp,
            modifier = Modifier.padding(4.dp, 15.dp),
            color = MaterialTheme.colorScheme.onSurface,
            lineHeight = 15.sp)
    }
}

@Composable
fun BottomBar() {
    Row(Modifier.fillMaxWidth(), Arrangement.SpaceAround, Alignment.CenterVertically) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Home, "Home")
            }
            AppText("Beranda", FontWeight.Medium, 14.sp,
                color = Purple20, modifier = Modifier.offset(y = (-10).dp))
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Newspaper, "Article")
            }
            AppText("Artikel", FontWeight.Medium, 14.sp,
                color = Purple20, modifier = Modifier.offset(y = (-10).dp))
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painterResource(R.drawable.profile), "Profile")
            }
            AppText("Profil", FontWeight.Medium, 14.sp,
                color = Purple20, modifier = Modifier.offset(y = (-10).dp))
        }
    }
}
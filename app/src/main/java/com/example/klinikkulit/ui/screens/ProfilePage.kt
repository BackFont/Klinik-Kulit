package com.example.klinikkulit.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.klinikkulit.R
import com.example.klinikkulit.ui.theme.Purple20
import com.example.klinikkulit.utils.AppText
import com.example.klinikkulit.utils.NavRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilePage(navController: NavHostController) {
    Scaffold(topBar = { TopBar(navController, "KlinikKulit")}, bottomBar = { BottomBar(navController) }) {
        Column(Modifier.padding(it).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(70.dp))
            Image(painterResource(R.drawable.mbappe), null)
            TextButton(onClick = { /*TODO*/ }) {
                AppText("Ganti Foto", fontSize = 15.sp, color = Purple20)
            }
            Spacer(Modifier.height(5.dp))
            AppText("Kylian Mbappe", FontWeight.Bold, 22.sp,
                color = MaterialTheme.colorScheme.onSurface)
            AppText("kylianmbappe@gmail.com", FontWeight.Bold, 15.sp, Purple20)
            Spacer(Modifier.height(30.dp))
            TextButton(onClick = { navController.navigate(NavRoute.EDIT_PROFILE.name) }) {
                AppText("Edit Profil", FontWeight.Bold, 15.sp, Purple20)
            }
        }
    }
}
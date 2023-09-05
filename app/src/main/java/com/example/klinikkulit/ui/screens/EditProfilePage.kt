package com.example.klinikkulit.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.klinikkulit.R
import com.example.klinikkulit.ui.theme.Purple20
import com.example.klinikkulit.ui.theme.lato
import com.example.klinikkulit.utils.AppText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfilePage(navController: NavHostController) {
    Scaffold(topBar = { TopBar(navController, "KlinikKulit")}) {
        Column(Modifier.padding(it).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(Modifier.height(70.dp))
            Image(painterResource(R.drawable.mbappe), null, Modifier.clip(CircleShape))
            TextButton(onClick = { /*TODO*/ }) {
                AppText("Ganti Foto", fontSize = 15.sp, color = Purple20)
            }
            Spacer(Modifier.height(17.dp))
            Column {
                Text("Nama", fontFamily = lato, fontSize = 15.sp)
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Purple20
                    )
                )
            }
            Spacer(Modifier.height(7.dp))
            Column {
                Text("Email", fontFamily = lato, fontSize = 15.sp)
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Purple20
                    )
                )
            }
            Spacer(Modifier.height(7.dp))
            Column {
                Text("No Telp", fontFamily = lato, fontSize = 15.sp)
                OutlinedTextField(
                    value = "",
                    onValueChange = { },
                    shape = RoundedCornerShape(8.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Purple20
                    )
                )
            }
            Spacer(Modifier.height(17.dp))
            Button(
                onClick = { },
                Modifier
                    .width(280.dp)
                    .padding(vertical = 20.dp),
                shape = RoundedCornerShape(7.dp),
                colors = ButtonDefaults.buttonColors(Purple20)
            ) {
                Text("Simpan", fontFamily = lato,
                    fontWeight = FontWeight.Medium, color = Color.White,
                    fontSize = 22.sp)
            }
        }
    }
}
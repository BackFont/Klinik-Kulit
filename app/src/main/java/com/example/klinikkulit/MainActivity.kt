package com.example.klinikkulit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.klinikkulit.ui.screens.LoginPage
import com.example.klinikkulit.ui.screens.SignUpPage
import com.example.klinikkulit.ui.theme.KlinikKulitTheme
import com.example.klinikkulit.utils.NavRoute

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            KlinikKulitTheme {
                // A surface container using the 'background' color from the theme
                NavHost(navController = navController, startDestination = NavRoute.LOGIN.name) {
                    composable(NavRoute.LOGIN.name) {
                        LoginPage(navController)
                    }
                    composable(NavRoute.SIGNUP.name) {
                        SignUpPage(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KlinikKulitTheme {
        Greeting("Android")
    }
}
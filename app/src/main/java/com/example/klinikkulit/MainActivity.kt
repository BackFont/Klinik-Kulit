package com.example.klinikkulit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.klinikkulit.ui.screens.ArticlesPage
import com.example.klinikkulit.ui.screens.CameraScreen
import com.example.klinikkulit.ui.screens.EditProfilePage
import com.example.klinikkulit.ui.screens.FAQPage
import com.example.klinikkulit.ui.screens.HomeScreen
import com.example.klinikkulit.ui.screens.LoginPage
import com.example.klinikkulit.ui.screens.ProfilePage
import com.example.klinikkulit.ui.screens.ScanResultScreen
import com.example.klinikkulit.ui.screens.SignUpPage
import com.example.klinikkulit.ui.theme.KlinikKulitTheme
import com.example.klinikkulit.utils.NavRoute
import com.example.klinikkulit.viewmodels.CameraViewModel

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            val viewModel: CameraViewModel = viewModel()

            KlinikKulitTheme {
                // A surface container using the 'background' color from the theme
                NavHost(navController = navController, startDestination = NavRoute.LOGIN.name) {
                    composable(NavRoute.LOGIN.name) {
                        LoginPage(navController)
                    }
                    composable(NavRoute.SIGNUP.name) {
                        SignUpPage(navController)
                    }
                    composable(NavRoute.HOME.name) {
                        HomeScreen(navController)
                    }
                    composable(NavRoute.FAQ.name) {
                        FAQPage(navController)
                    }
                    composable(NavRoute.PROFILE.name) {
                        ProfilePage(navController)
                    }
                    composable(NavRoute.EDIT_PROFILE.name) {
                        EditProfilePage(navController)
                    }
                    composable(NavRoute.CAMERA.name) {
                        val cameraState by viewModel.state.collectAsStateWithLifecycle()
                        CameraScreen(navController, cameraState, viewModel::onPhotoCaptured)
                    }
                    composable(NavRoute.SCAN_RESULT.name) {
                        val cameraState by viewModel.state.collectAsStateWithLifecycle()
                        cameraState.capturedImage?.let {
                            ScanResultScreen(it, navController, viewModel::onCapturedPhotoConsumed)
                        }
                    }
                    composable(NavRoute.ARTICLES.name) {
                        ArticlesPage(navController)
                    }
                }
            }
        }
    }
}
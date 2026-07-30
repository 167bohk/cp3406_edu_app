package com.example.cp3406_a3_edu_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cp3406_a3_edu_app.ui.AstronomyApp
import com.example.cp3406_a3_edu_app.ui.AstronomyViewModel
import com.example.cp3406_a3_edu_app.ui.AstronomyViewModelFactory
import com.example.cp3406_a3_edu_app.ui.theme.Cp3406_a3_edu_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val application = application as AstronomyApplication
            Cp3406_a3_edu_appTheme(darkTheme = true, dynamicColor = false) {
                AstronomyApp(
                    viewModel = viewModel<AstronomyViewModel>(
                        factory = AstronomyViewModelFactory(application.container)
                    )
                )
            }
        }
    }
}

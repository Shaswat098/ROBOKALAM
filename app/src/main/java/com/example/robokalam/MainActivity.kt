package com.example.robokalam
import RobokalamAppTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.robokalam.app.navigation.Navigation
import com.example.robokalam.data.viewmodel.AppViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RobokalamAppTheme {
                val appViewModel: AppViewModel = viewModel(factory = AppViewModel.Factory(application))
                Navigation(viewModel = appViewModel , startDestination = "Screen.Splash.route")
            }
        }
    }
}

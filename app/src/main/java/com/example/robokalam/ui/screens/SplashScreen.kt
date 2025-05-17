package com.example.robokalam.ui.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.robokalam.R
import com.example.robokalam.SharedPrefHelper
import com.example.robokalam.navigation.Screen

@Composable
fun SplashScreen(navController: NavController) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(2000)
        val isLoggedIn = SharedPrefHelper.getLoginStatus(context)
            if(isLoggedIn){
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            } else {
                navController.navigate(Screen.Login.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(R.drawable.logo), contentDescription = "Logo")
            Spacer(modifier = Modifier.height(16.dp))
            Text("Robokalam", style = MaterialTheme.typography.headlineMedium)
        }
    }
}
package com.robokalam.app.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.robokalam.SharedPrefHelper
import com.example.robokalam.navigation.Screen
import com.example.robokalam.data.viewmodel.AppViewModel

@Composable
fun HomeScreen(navController: NavController, viewModel: AppViewModel) {
    val context = LocalContext.current

    // Get email from Shared Preferences
    val email = SharedPrefHelper.getLoggedInUserEmail(context) ?: "User"
    val username = SharedPrefHelper.getLoggedInUserName(context) ?: "User"
    val quote by viewModel.quote.observeAsState("Loading...")

    // Trigger once when the screen is composed
    LaunchedEffect(Unit) {
        viewModel.fetchQuote()
        viewModel.loadPortfolio(email)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        // Greeting with Username
        Text(
            text = "Welcome back, $username!",
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Quote of the Day Section
        Text(
            text = "✨ Quote of the Day:",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
        )
        Text(
            text = quote,
            modifier = Modifier.padding(top = 8.dp),
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Action Buttons
        Button(
            onClick = { navController.navigate(Screen.Portfolio.route) },
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        ) {
            Text("View/Edit Portfolio")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { navController.navigate(Screen.About.route) },
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
        ) {
            Text("About RoboKalam")
        }

        Spacer(modifier = Modifier.weight(1f))

        // Logout Button
        Button(
            onClick = {
                SharedPrefHelper.setLoginStatus(context, false)
                SharedPrefHelper.clearLoginStatus(context)
                navController.navigate(Screen.Login.route) {
                    popUpTo(Screen.Home.route) { inclusive = true }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
        ) {
            Text("Logout", color = MaterialTheme.colorScheme.onError)
        }
    }
}

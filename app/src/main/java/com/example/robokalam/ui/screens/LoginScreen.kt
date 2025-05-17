package com.robokalam.app.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.robokalam.SharedPrefHelper
import com.example.robokalam.navigation.Screen

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var usernameError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("Login", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it
                usernameError = null
            },
            label = { Text("Username") },
            isError = usernameError != null,
            modifier = Modifier.fillMaxWidth()
        )
        if (usernameError != null) {
            Text(
                text = usernameError ?: "",
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                emailError = null
            },
            label = { Text("Email") },
            isError = emailError != null,
            modifier = Modifier.fillMaxWidth()
        )
        if (emailError != null) {
            Text(
                text = emailError ?: "",
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                passwordError = null
            },
            label = { Text("Password") },
            isError = passwordError != null,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        if (passwordError != null) {
            Text(
                text = passwordError ?: "",
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                var valid = true

                if (username.isBlank()) {
                    usernameError = "Username cannot be empty"
                    valid = false
                }

                if (email.isBlank()) {
                    emailError = "Email cannot be empty"
                    valid = false
                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailError = "Invalid email format"
                    valid = false
                }

                if (password.isBlank()) {
                    passwordError = "Password cannot be empty"
                    valid = false
                } else if (password.length < 6) {
                    passwordError = "Password must be at least 6 characters"
                    valid = false
                }

                if (valid) {
                    SharedPrefHelper.setLoggedInUserName(context, username)
                    SharedPrefHelper.setLoggedInUserEmail(context, email)
                    SharedPrefHelper.setLoginStatus(context, true)
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
    }
}

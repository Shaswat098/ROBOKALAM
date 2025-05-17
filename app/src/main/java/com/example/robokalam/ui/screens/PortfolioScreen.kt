package com.robokalam.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.robokalam.SharedPrefHelper
import com.example.robokalam.data.db.Portfolio
import com.example.robokalam.data.viewmodel.AppViewModel

@Composable
fun PortfolioScreen(navController: NavController, viewModel: AppViewModel) {
    val context = LocalContext.current
    val email = SharedPrefHelper.getLoggedInUserEmail(context) ?: ""

    var username by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var college by remember { mutableStateOf("") }
    var skills by remember { mutableStateOf("") }
    var project by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    val portfolio by viewModel.portfolio.observeAsState()

    LaunchedEffect(email) {
        if (email.isNotEmpty()) {
            viewModel.loadPortfolio(email)
        }
    }

    LaunchedEffect(portfolio) {
        portfolio?.let {
            username = it.username
            name = it.name
            college = it.college
            skills = it.skills
            project = it.projectTitle
            description = it.projectDescription
        }
    }

    // Validation check for skills count
    val skillsList = skills.split(",").map { it.trim() }.filter { it.isNotEmpty() }
    val isSkillsValid = skillsList.size >= 3

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp)) {

        Text("Your Portfolio", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = college,
            onValueChange = { college = it },
            label = { Text("College") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = skills,
            onValueChange = { skills = it },
            label = { Text("Skills (comma separated, min 3)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        if (!isSkillsValid) {
            Text(
                text = "Please enter at least 3 skills.",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = project,
            onValueChange = { project = it },
            label = { Text("Project Title") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Project Description") },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            maxLines = 5
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                viewModel.savePortfolio(
                    Portfolio(
                        email = email,
                        username = username,
                        password = "", // Handle password appropriately
                        name = name,
                        college = college,
                        skills = skillsList.joinToString(","),
                        projectTitle = project,
                        projectDescription = description
                    )
                ) {
                    navController.popBackStack()
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = isSkillsValid // disable if skills not valid
        ) {
            Text("Save Portfolio")
        }
    }
}

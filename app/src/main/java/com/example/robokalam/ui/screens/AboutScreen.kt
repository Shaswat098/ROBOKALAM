package com.example.robokalam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.robokalam.R

@Composable
fun AboutScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Robokalam Logo", modifier = Modifier.size(120.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Text("About Robokalam", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text("ROBOKALAM is a 21st century Edutech company," +
                " which focuses on Gamified education solutions,covering technical Education" +
                " and doing Research & development in latest technologies like AI,IoT,Coding,Robotics etc." +
                " We provide Workshops, Training Certifications, DIY Kits to insitutes all around the world." +
                " The current training  system provides a hands-on experiences and exposure in the latest technologies" +
                " to the students. Apart from this, we have organized technical and student centric Outreach Programs in Government Institutions." +
                " Every Year, we used to organize our own well reputed fest named SKOOL ENGINE in association with Samaritans Stand Up Organization." +
                " We have been successfully organizing the annual editions of student innovation platform SKOOL ENGINE since 2015.  ")
    }
}
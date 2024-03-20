package com.example.randompassword.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.randompassword.navGraph.RouteItem
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navHost: NavController) {

    LaunchedEffect(key1 = true) {
        delay(300)
        navHost.popBackStack()
        navHost.navigate(RouteItem.HomeScreen.route)
    }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Unique Password", style = MaterialTheme.typography.titleLarge)
        }
}
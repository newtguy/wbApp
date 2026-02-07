package com.example.wbapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.*

import com.example.wbapp.cessna172
import com.example.wbapp.cherokee180
import com.example.wbapp.Aircraft


@Composable
fun AircraftSelectionScreen(onSelect: (Aircraft) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()               // Column takes the full screen
            .padding(16.dp),             // Add padding around edges
        verticalArrangement = Arrangement.Center, // Center vertically
        horizontalAlignment = Alignment.CenterHorizontally, // Center horizontally
        // Spacing between buttons
    ) {
        Text(
            "Select Aircraft",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 24.dp) // space below title
        )

        Button(
            onClick = { onSelect(cessna172) },
            modifier = Modifier
                .fillMaxWidth(0.7f)   // Button takes 70% of screen width
                .padding(bottom = 12.dp)
        ) {
            Text("Cessna 172S", style = MaterialTheme.typography.bodyLarge)
        }

        Button(
            onClick = { onSelect(cherokee180) },
            modifier = Modifier
                .fillMaxWidth(0.7f)
        ) {
            Text("Piper Cherokee PA-28-180", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

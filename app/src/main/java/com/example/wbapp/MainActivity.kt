package com.example.wbapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.wbapp.screens.AircraftSelectionScreen
import com.example.wbapp.screens.InputWeightsScreen
import com.example.wbapp.ui.theme.WBAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WBAppTheme {
                var selectedAircraft by remember { mutableStateOf<Aircraft?>(null) }

                if (selectedAircraft == null) {
                    AircraftSelectionScreen { aircraft ->
                        selectedAircraft = aircraft
                    }
                } else {
                    InputWeightsScreen(selectedAircraft!!) { result ->
                        // Here you can show a dialog, Toast, or just keep updating the UI
                    }
                }
            }
        }
    }
}

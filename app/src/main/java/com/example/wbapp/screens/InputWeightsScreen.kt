package com.example.wbapp.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.wbapp.Aircraft
import com.example.wbapp.WbResult
import com.example.wbapp.calculateCg
import com.example.wbapp.ui.theme.Error
import com.example.wbapp.ui.theme.Secondary

private const val FUEL_LB_PER_GALLON = 6.0

@Composable
fun InputWeightsScreen(
    aircraft: Aircraft,
    onResult: (WbResult) -> Unit
) {
    val context = LocalContext.current

    var frontPilot by remember { mutableStateOf("") }
    var rearPassenger by remember { mutableStateOf("") }
    var baggage by remember { mutableStateOf("") }
    var fuelGallons by remember { mutableStateOf("") }
    var cgResult by remember { mutableStateOf<WbResult?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // Scroll for small screens
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Aircraft: ${aircraft.name}",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Input fields
        OutlinedTextField(
            value = frontPilot,
            onValueChange = { frontPilot = it },
            label = { Text("Front Pilot Weight (lbs)") },
            modifier = Modifier.fillMaxWidth(0.8f).padding(bottom = 12.dp)
        )

        OutlinedTextField(
            value = rearPassenger,
            onValueChange = { rearPassenger = it },
            label = { Text("Rear Passenger Weight (lbs)") },
            modifier = Modifier.fillMaxWidth(0.8f).padding(bottom = 12.dp)
        )

        OutlinedTextField(
            value = baggage,
            onValueChange = { baggage = it },
            label = { Text("Baggage Weight (lbs)") },
            modifier = Modifier.fillMaxWidth(0.8f).padding(bottom = 12.dp)
        )

        OutlinedTextField(
            value = fuelGallons,
            onValueChange = { fuelGallons = it },
            label = { Text("Fuel (gallons)") },
            modifier = Modifier.fillMaxWidth(0.8f).padding(bottom = 24.dp)
        )

        //Calculate CG button
        Button(
            onClick = {
                val fuelLbs = fuelGallons.toDoubleOrNull().orZero() * FUEL_LB_PER_GALLON
                val weights = mapOf(
                    "front_pilot" to frontPilot.toDoubleOrNull().orZero(),
                    "rear_passenger" to rearPassenger.toDoubleOrNull().orZero(),
                    "baggage" to baggage.toDoubleOrNull().orZero(),
                    "fuel" to fuelLbs
                )

                val result = calculateCg(aircraft, weights)
                cgResult = result

                if (!result.withinMaxWeight) {
                    Toast.makeText(
                        context,
                        "WARNING: Aircraft overweight!",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                // Always pass the result to parent
                onResult(result)
            },
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("Calculate CG", style = MaterialTheme.typography.bodyLarge)
        }

        // Display results (if result okay)
        cgResult?.let { result ->
            Spacer(modifier = Modifier.height(16.dp))

            // CG display
            Text(
                "CG: %.2f (%s)".format(
                    result.cg,
                    if (result.withinEnvelope) "Within limits" else "OUT OF LIMITS"
                ),
                color = if (result.withinEnvelope) Secondary else Error,
                style = MaterialTheme.typography.bodyLarge
            )

            // Total Weight Display
            Text(
                "Total Weight: %.1f / %.1f lbs".format(result.totalWeight, aircraft.maxWeight),
                color = if (result.withinMaxWeight) Secondary else Error,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 8.dp)
            )

            // Warning message for overweight aircraft
            if (!result.withinMaxWeight) {
                Text(
                    "WARNING: Aircraft overweight!",
                    color = Error,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

//Accounts for improper field entries (letters)
// Will return default of 0 if invalid or empty
fun Double?.orZero() = this ?: 0.0

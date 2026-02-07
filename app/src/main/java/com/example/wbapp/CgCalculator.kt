package com.example.wbapp

// Performs W&B calculations
// - weight * arm = moment
// - find totalMoment and totalWeight, then find quotient which = center of gravity
fun calculateCg(aircraft: Aircraft, weights: Map<String, Double>): WbResult {
    val totalMoment = weights.entries.sumOf { (station, weight) ->
        weight * (aircraft.arms[station] ?: 0.0)
    }

    val totalWeight = weights.values.sum()
    val cg = if (totalWeight > 0) totalMoment / totalWeight else 0.0
    val withinEnvelope = cg in aircraft.minCg..aircraft.maxCg
    val withinMaxWeight = totalWeight <= aircraft.maxWeight

    return WbResult(
        totalWeight = totalWeight,
        cg = cg,
        withinEnvelope = withinEnvelope,
        withinMaxWeight = withinMaxWeight
    )
}


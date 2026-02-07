package com.example.wbapp

data class Aircraft(
    val name: String,
    val arms: Map<String, Double>,
    val minCg: Double,
    val maxCg: Double,
    val maxWeight: Double
)

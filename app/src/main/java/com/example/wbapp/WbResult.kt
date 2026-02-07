package com.example.wbapp

data class WbResult(
    val totalWeight: Double,
    val cg: Double,
    val withinEnvelope: Boolean,
    val withinMaxWeight: Boolean
)

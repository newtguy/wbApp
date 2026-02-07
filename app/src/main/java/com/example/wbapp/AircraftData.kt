package com.example.wbapp

//Arms measured in inches, Weights measure in pounds
val cessna172 = Aircraft(
    name = "Cessna 172S",
    arms = mapOf(
        "front_pilot" to 37.0,
        "rear_passenger" to 73.0,
        "baggage" to 95.0,
        "fuel" to 48.0
    ),
    minCg = 35.0,
    maxCg = 47.3,
    maxWeight = 2550.0
)

val cherokee180 = Aircraft(
    name = "Piper Cherokee PA-28-180",
    arms = mapOf(
        "front_pilot" to 85.5,
        "rear_passenger" to 118.1,
        "baggage" to 142.8,
        "fuel" to 95.0
    ),
    minCg = 85.0,
    maxCg = 95.5,
    maxWeight = 2400.0
)

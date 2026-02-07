# WBApp — Weight & Balance Calculator

WBApp is an Android app written in Kotlin using Jetpack Compose that performs **Weight and Balance calculations** for general aviation aircraft.

Pilots can quickly check whether their aircraft is **within operating limitations** by entering passenger, baggage, and fuel weights. The app calculates **center of gravity (CG)** and **total weight**, highlighting any limits exceeded.

[W&B Demo Video](https://www.loom.com/share/a5e7d85e118e4da4ab7adc6ac9586e3b)

---

## Development Environment

- **Android Studio**
- **Kotlin + Jetpack Compose**
- **Libraries:** Material3, Core KTX

---

## Features

- Predefined aircraft (Cessna 172S, Piper Cherokee PA-28-180) with CG envelopes and max weights
- Input weights for passengers, baggage, and fuel (fuel in gallons, auto-converted to pounds)
- Calculates **total weight** and **center of gravity** in inches
- Displays warnings if CG or weight limits are exceeded
- Scrollable, mobile-friendly UI with Material3 styling

---

## Useful Websites

- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Material3 Components](https://developer.android.com/jetpack/compose/material3)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)

---

## Future Work

- Add additional aircraft profiles (predefined or JSON-based)
- Add a menu to select different aircraft or input custom aircraft data
- Display CG graphically within the aircraft's envelope
- Validate weight inputs and fuel entries
- Implement performance calculations based on current weather observations  

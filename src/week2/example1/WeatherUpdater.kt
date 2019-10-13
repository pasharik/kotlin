package week2.example1

import week2.example1.Color.*


class WeatherUpdater {
    fun updateWeather(degrees: Int): Unit { //Unit - means 'void' in Kotlin
        val (description: String, color: Color) = when {
            degrees < 10 -> "cold" to BLUE
            degrees < 25 -> "mild" to ORANGE
            else -> "hot" to RED
        }
        println("$description - $color")
    }
}

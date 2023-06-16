package com.example.weatherapp.data.remote.dto

data class Current(
    val cloud: Int,
    val condition: Condition,
    val feelslike_c: Double,
    val humidity: Int,
    val is_day: Int,
    val last_updated: String,
    val temp_c: Double,
    val uv: Double,
    val vis_km: Double,
    val vis_miles: Double,
    val wind_kph: Double
)
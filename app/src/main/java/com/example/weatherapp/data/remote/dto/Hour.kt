package com.example.weatherapp.data.remote.dto

data class Hour(
    val condition: ConditionXX,
    val temp_c: Double,
    val time: String,
    val wind_kph: Double,
    val windchill_c: Double,
    val windchill_f: Double
)
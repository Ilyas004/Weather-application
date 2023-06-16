package com.example.weatherapp.data.remote.dto

data class Day(
    val condition: Condition,
    val maxtemp_c: Double,
    val mintemp_c: Double,
    val totalsnow_cm: Double
)
package com.example.weatherapp.data.remote.dto

data class Forecastday(
    val astro: Astro,
    val date: String,
    val day: Day,
    val hour: List<Hour>
)
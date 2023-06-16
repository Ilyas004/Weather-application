package com.example.weatherapp.data.remote.dto

data class Weather(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)
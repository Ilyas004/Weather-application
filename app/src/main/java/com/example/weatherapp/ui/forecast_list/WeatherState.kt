package com.example.weatherapp.ui.forecast_list

import com.example.weatherapp.data.remote.dto.Weather

data class WeatherState(
    val weatherInfo: Weather? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

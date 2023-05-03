package com.example.weatherapp.data.repository

import com.example.weatherapp.data.remote.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: WeatherApi
) {

    suspend fun getForecast() {}
}
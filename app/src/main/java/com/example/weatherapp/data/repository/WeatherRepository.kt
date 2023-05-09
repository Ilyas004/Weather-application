package com.example.weatherapp.data.repository

import androidx.lifecycle.LiveData
import com.example.weatherapp.data.model.Weather
import com.example.weatherapp.data.remote.WeatherApi
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: WeatherApi
) {

    suspend fun getForecast(key: String): Response<Weather> {
        return api.getForecast(key)
    }
}
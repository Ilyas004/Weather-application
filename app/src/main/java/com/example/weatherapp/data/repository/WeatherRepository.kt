package com.example.weatherapp.data.repository

import com.example.weatherapp.data.remote.WeatherApi
import com.example.weatherapp.data.remote.dto.Weather
import com.example.weatherapp.util.Constant
import com.example.weatherapp.util.Resource
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val api: WeatherApi
) {

    suspend fun getWeatherByLocation(location: String): Resource<Weather> {
        return try {
            Resource.Success(
                data = api.getForecastByLocation(Constant.KEY, location)
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }

    }

    suspend fun getWeatherByNameCity(nameCity: String): Resource<Weather> {
        return api.getForecastByNameCity(Constant.KEY, nameCity)
    }
}
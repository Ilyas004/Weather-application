package com.example.weatherapp.data.remote

import com.example.weatherapp.data.remote.dto.Weather
import com.example.weatherapp.util.Resource
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/current.json?&days=3&lang=ru")
    suspend fun getForecastByNameCity(
        @Query("key") key: String,
        @Query("q") nameCity: String
    ): Resource<Weather>

    @GET("v1/forecast.json?&days=3&lang=ru")
    suspend fun getForecastByLocation(
        @Query("key") key: String,
        @Query("q") location: String
    ): Weather
}
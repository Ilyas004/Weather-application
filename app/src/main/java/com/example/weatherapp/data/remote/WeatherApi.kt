package com.example.weatherapp.data.remote

import androidx.lifecycle.LiveData
import com.example.weatherapp.data.model.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/current.json?q=Kaspiysk")
    suspend fun getForecast(
        @Query("key") key: String
    ): Response<Weather>
}
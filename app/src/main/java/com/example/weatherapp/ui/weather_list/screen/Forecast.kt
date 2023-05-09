package com.example.weatherapp.ui.weather_list.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.example.weatherapp.ui.weather_list.viewmodel.WeatherViewModel

@Composable
fun Forecast(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val forecast = viewModel.forecast.observeAsState()
    Text(text = forecast.value?.body()?.location?.name ?: "MAGAAA")
}
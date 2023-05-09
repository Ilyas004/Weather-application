package com.example.weatherapp.ui.weather_list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.model.Weather
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.util.Constant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    private val _forecast = MutableLiveData<Response<Weather>>()
    val forecast: LiveData<Response<Weather>>
        get() = _forecast

    init {
        getForecast()
    }

    private fun getForecast() {
        viewModelScope.launch {
            _forecast.postValue(repository.getForecast(Constant.KEY))
        }
    }
}
package com.example.weatherapp.ui.forecast_list.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.forecast_list.WeatherState

@Composable
fun ForecastDisplay(
    state: WeatherState,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.let { data ->
        Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Прогноз на 3 дня",
                    color = Color.Gray,
                    fontSize = 20.sp,
                )
                WeatherDayInfo(
                    url = data.forecast.forecastday[0].day.condition.icon,
                    text = "Сегодня ",
                    maxTemperature = data.forecast.forecastday[0].day.maxtemp_c,
                    minTemperature = data.forecast.forecastday[0].day.mintemp_c
                )
                WeatherDayInfo(
                    url = data.forecast.forecastday[1].day.condition.icon,
                    text = "Завтра ",
                    maxTemperature = data.forecast.forecastday[1].day.maxtemp_c,
                    minTemperature = data.forecast.forecastday[1].day.mintemp_c
                )
                WeatherDayInfo(
                    url = data.forecast.forecastday[2].day.condition.icon,
                    text = "Послезавтра ",
                    maxTemperature = data.forecast.forecastday[2].day.maxtemp_c,
                    minTemperature = data.forecast.forecastday[2].day.mintemp_c
                )

            }
        }
    }
}

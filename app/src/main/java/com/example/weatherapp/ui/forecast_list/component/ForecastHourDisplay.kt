package com.example.weatherapp.ui.forecast_list.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.forecast_list.WeatherState
import com.example.weatherapp.ui.theme.Blue

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ForecastHourDisplay(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.forecast?.forecastday?.get(0)?.let { data ->
        Card(
            backgroundColor = Blue,
            modifier = Modifier.padding(16.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Прогноз на 24 часа",
                    fontSize = 20.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyRow(content = {
                    items(data.hour) { weatherData ->
                        HourWeatherInfo(
                            weatherData = weatherData,
                            modifier = Modifier
                                .height(100.dp)
                                .padding(horizontal = 16.dp)
                        )
                    }
                }
                )
            }
        }

    }
}
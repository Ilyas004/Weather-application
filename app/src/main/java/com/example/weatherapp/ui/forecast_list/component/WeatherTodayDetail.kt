package com.example.weatherapp.ui.forecast_list.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.forecast_list.WeatherState

@Composable
fun WeatherTodayDetail(
    state: WeatherState,
    modifier: Modifier = Modifier,
    backgroundColor: Color
) {
    state.weatherInfo?.let { data ->
        Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Влажность  ${data.current.humidity}%",
                    fontSize = 16.sp,
                    color = Color.LightGray
                )
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                Text(
                    text = "Ощущается ${data.current.feelslike_c}°",
                    fontSize = 16.sp,
                    color = Color.LightGray
                )
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
                Text(
                    text = "Видимость ${data.current.vis_km}км",
                    fontSize = 16.sp,
                    color = Color.LightGray
                )
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
        }
    }
}
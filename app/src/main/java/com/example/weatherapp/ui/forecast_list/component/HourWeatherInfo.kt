package com.example.weatherapp.ui.forecast_list.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.weatherapp.data.remote.dto.Hour

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HourWeatherInfo(
    weatherData: Hour,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White
) {
    val time = weatherData.time.substringAfter(" ")

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = time,
            color = Color.LightGray
        )
        AsyncImage(
            model = "https:${weatherData.condition.icon}",
            contentDescription = null,
            modifier = Modifier.width(40.dp)
        )
        Text(
            text = "${weatherData.temp_c}°C",
            color = textColor,
            fontWeight = FontWeight.Bold
        )
    }

}
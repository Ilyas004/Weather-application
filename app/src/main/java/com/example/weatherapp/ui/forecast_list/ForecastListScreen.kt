package com.example.weatherapp.ui.forecast_list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherapp.ui.forecast_list.component.ForecastDisplay
import com.example.weatherapp.ui.forecast_list.component.ForecastHourDisplay
import com.example.weatherapp.ui.forecast_list.component.WeatherCard
import com.example.weatherapp.ui.forecast_list.component.WeatherTodayDetail
import com.example.weatherapp.ui.theme.Blue
import com.example.weatherapp.ui.theme.DarkBlue


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ForecastListScreen(
    viewModel: ForecastListViewModel = hiltViewModel()
) {
    
    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkBlue)
        ) {item {
            WeatherCard(state = viewModel.state, backgroundColor = Blue)
            Spacer(modifier = Modifier.height(16.dp))
            ForecastHourDisplay(state = viewModel.state)
            Spacer(modifier = Modifier.height(16.dp))
            ForecastDisplay(state = viewModel.state, backgroundColor = Blue)
            WeatherTodayDetail(state = viewModel.state, backgroundColor = Blue)
            }

        }

        if(viewModel.state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
        viewModel.state.error?.let { error ->
            Text(
                text = error,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }

}
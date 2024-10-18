package com.example.weather.model


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.Api.ApiKey
import com.example.weather.Api.RetrofitInstance
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {

    private val weatherApi = RetrofitInstance.weatherApi

    fun getData(city: String) {
        viewModelScope.launch {
            // Getting the data is asynchronous process obv
            weatherApi.getWeather(ApiKey.apiKey, city)
        }

    }
}
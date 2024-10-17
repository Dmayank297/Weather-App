package com.example.weather.model


import android.util.Log
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel

class WeatherViewModel: ViewModel() {

    fun getData(city: String) {
        Log.i("City", city)
    }
}
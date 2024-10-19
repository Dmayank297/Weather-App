package com.example.weather.model


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.Api.ApiKey
import com.example.weather.Api.NetworkResponse
import com.example.weather.Api.RetrofitInstance
import com.example.weather.Data.WeatherData
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {

    private val weatherApi = RetrofitInstance.weatherApi
    private val _weatherResult = MutableLiveData<NetworkResponse<WeatherData>>()
    val weatherResult : LiveData<NetworkResponse<WeatherData>> = _weatherResult

    fun getData(city: String) {
        _weatherResult.value = NetworkResponse.Loading
        Log.i("CIty", city)
        viewModelScope.launch {
            // Getting the data is asynchronous process obv
            try {
                val response = weatherApi.getWeather(ApiKey.apiKey, city)
                if(response.isSuccessful) {
                    response.body()?.let {
                        _weatherResult.value = NetworkResponse.Success(it)
                        Log.i("Success", city)
                    }
                } else {
                    _weatherResult.value = NetworkResponse.Error(
                        message = "Failed to load data")
                }
            } catch (e : Exception) {
                _weatherResult.value = NetworkResponse.Error("Unexpected error!")
            }


        }

    }
}
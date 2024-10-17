package com.example.weather

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weather.model.WeatherViewModel

@Composable
fun SearchPage(
    modifier: Modifier,
    viewModel: WeatherViewModel
) {
    var city by remember {mutableStateOf("")}

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = city,
                onValueChange = {
                city = it
            },
                label = {
                    Text(text = "Enter City Name")
                },
                shape = RoundedCornerShape(16.dp)
            )
            
            IconButton(onClick = {
            // Call viewModel to fetch city data
                viewModel.getData(city)
                city = ""

            }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search for location")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearch() {
    val weatherViewModel = WeatherViewModel()
    SearchPage(modifier = Modifier, weatherViewModel)
}
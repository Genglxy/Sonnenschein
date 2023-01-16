package com.sonnenschein.android.ui.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sonnenschein.android.logic.Repository
import com.sonnenschein.android.logic.model.PlaceResponse

class WeatherViewModel : ViewModel() {

    private val locationLiveData = MutableLiveData<PlaceResponse.Location>()
    var locationLng = ""
    var locationLat = ""
    var placeName = ""
    val weatherLiveData = Transformations.switchMap(locationLiveData) { location ->
        Repository.refreshWeather(location.lng, location.lat)
    }

    fun refreshWeather(lng: String, lat: String) {
        locationLiveData.value = PlaceResponse.Location(lng, lat)
    }
}
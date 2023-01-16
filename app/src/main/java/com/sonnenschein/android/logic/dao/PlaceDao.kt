package com.sonnenschein.android.logic.dao


import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.sonnenschein.android.SonnenscheinApplication
import com.sonnenschein.android.logic.model.PlaceResponse

object PlaceDao {

    fun savePlace(place: PlaceResponse.Place) {
        sharedPreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavedPlace(): PlaceResponse.Place {
        val placeJson = sharedPreferences().getString("place", "")
        return Gson().fromJson(placeJson, PlaceResponse.Place::class.java)
    }

    fun isPlacedSaved() = sharedPreferences().contains("place")

    private fun sharedPreferences() =
        SonnenscheinApplication.context.getSharedPreferences("sonnenschein", Context.MODE_PRIVATE)
}
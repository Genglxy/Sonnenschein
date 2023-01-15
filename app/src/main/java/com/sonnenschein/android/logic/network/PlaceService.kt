package com.sonnenschein.android.logic.network

import com.sonnenschein.android.SonnenscheinApplication
import com.sonnenschein.android.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {

    @GET("v2/place?token=${SonnenscheinApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query: String): Call<PlaceResponse>
}
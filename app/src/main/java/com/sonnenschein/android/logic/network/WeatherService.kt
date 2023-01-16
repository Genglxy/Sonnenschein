package com.sonnenschein.android.logic.network

import com.sonnenschein.android.R
import com.sonnenschein.android.SonnenscheinApplication
import com.sonnenschein.android.logic.model.DailyResponse
import com.sonnenschein.android.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherService {

    @GET("v2.6/{token}/{lng},{lat}/realtime.json")
    fun getRealtimeWeather(
        @Path("lng") lng: String,
        @Path("lat") lat: String,
        @Path("token") token: String = SonnenscheinApplication.context.getString(R.string.token)
    ): Call<RealtimeResponse>

    @GET("v2.6/{token}/{lng},{lat}/daily.json")
    fun getDailyWeather(
        @Path("lng") lng: String,
        @Path("lat") lat: String,
        @Path("token") token: String = SonnenscheinApplication.context.getString(R.string.token)
    ): Call<DailyResponse>
}
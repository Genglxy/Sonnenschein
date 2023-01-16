package com.sonnenschein.android.logic.network

import com.sonnenschein.android.R
import com.sonnenschein.android.SonnenscheinApplication
import com.sonnenschein.android.SonnenscheinApplication.Companion.context
import com.sonnenschein.android.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceService {

    @GET("v2/place?token=lang=zh_CN")
    fun searchPlaces(
        @Query("query") query: String,
        @Query("lang") lang: String = context.getString(R.string.language),
        @Query("token") token: String = SonnenscheinApplication.context.getString(R.string.token)
    ): Call<PlaceResponse>

}
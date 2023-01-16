package com.sonnenschein.android.logic.model

import com.google.gson.annotations.SerializedName

data class GeneralResponse(
    val status: String,
    val result: Result,
    @SerializedName("server_time") val serverTime: Long
) {
    data class Result(val realtime: RealtimeResponse.Realtime, val daily: DailyResponse.Daily)
}
package com.sonnenschein.android.logic.model

import com.google.gson.annotations.SerializedName

data class RealtimeResponse(
    val status: String,
    val result: Result,
    @SerializedName("server_time") val serverTime: Long
) {

    data class Result(val realtime: Realtime)

    data class Realtime(
        val status: String,
        val temperature: Float,
        val humidity: Float,
        val cloudrate: Float,
        val skycon: String,
        val visibility: Float,
        val dswrf: Float,
        val wind: Wind,
        val pressure: Float,
        @SerializedName("apparent_temperature") val apparentTemperature: Float,
        val precipitation: Precipitation,
        @SerializedName("air_quality") val airQuality: AirQuality,
        @SerializedName("life_index") val lifeIndex: LifeIndex,
    )

    data class Precipitation(val local: Local)

    data class Local(val status: String, val datasource: String, val intensity: Float)

    data class Wind(val speed: Float, val direction: Float)

    data class AirQuality(
        val pm25: Int,
        val pm10: Int,
        val o3: Int,
        val so2: Int,
        val no2: Int,
        val co: Float,
        val aqi: AQI,
        val description: Description
    )

    data class AQI(val chn: Float, val usa: Float)

    data class Description(val chn: String, val usa: String)

    data class LifeIndex(val ultraviolet: Ultraviolet, val comfort: Comfort)

    data class Ultraviolet(val index: Float, val desc: String)

    data class Comfort(val index: Float, val desc: String)

}

package com.sonnenschein.android.logic.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class DailyResponse(
    val status: String,
    val result: Result,
    @SerializedName("server_time") val serverTime: Long
) {

    data class Result(val daily: Daily)

    data class Daily(
        val astro: List<Astro>,
        @SerializedName("precipitation_08h_20h") val precipitationDay: List<Precipitation>,
        @SerializedName("precipitation_20h_32h") val precipitationNight: List<Precipitation>,
        val precipitation: List<Precipitation>,
        val temperature: List<Temperature>,
        @SerializedName("temperature_08h_20h") val temperatureDay: List<Temperature>,
        @SerializedName("temperature_20h_32h") val temperatureNight: List<Temperature>,
        val wind: List<Wind>,
        @SerializedName("wind_08h_20h") val windDay: List<Wind>,
        @SerializedName("wind_20h_32h") val windNight: List<Wind>,
        val humidity: List<DMMA>,
        val cloudrate: List<DMMA>,
        val pressure: List<DMMA>,
        val visibility: List<DMMA>,
        val dswrf: List<DMMA>,
        @SerializedName("air_quality") val airQuality: AirQuality,
        val skycon: List<Skycon>,
        @SerializedName("skycon_08h_20h") val skyconDay: List<Skycon>,
        @SerializedName("skycon_20h_32h") val skyconNight: List<Skycon>,
        @SerializedName("life_index") val lifeIndex: LifeIndex
    )

    data class Astro(val date: Date, val sunrise: Sun, val sunset: Sun)

    data class Sun(val time: String)

    data class Precipitation(
        val date: Date, val max: Float, val min: Float, val avg: Float, val probability: Int
    )

    data class Temperature(val max: Float, val min: Float)

    data class Wind(val date: Date, val max: WindSpeed, val min: WindSpeed, val avg: WindSpeed)

    data class WindSpeed(val speed: Float, val direction: Float)

    data class DMMA(val date: Date, val max: Float, val min: Float, val avg: Float)

    data class AirQuality(val aqi: List<AQI>, val pm25: List<Pm25>)

    data class AQI(val date: Date, val max: AQIN, val min: AQIN, val avg: AQIN)

    data class AQIN(val chn: Int, val usa: Int)

    data class Pm25(val date: Date, val max: Int, val min: Int, val avg: Int)

    data class Skycon(val value: String, val date: Date)

    data class LifeIndex(
        val ultraviolet: List<LifeDescription>,
        val carWashing: List<LifeDescription>,
        val dressing: List<LifeDescription>,
        val comfort: List<LifeDescription>,
        val coldRisk: List<LifeDescription>
    )

    data class LifeDescription(val desc: String)

}

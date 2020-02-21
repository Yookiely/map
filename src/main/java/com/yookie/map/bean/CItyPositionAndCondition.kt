package com.yookie.map.bean

import com.yookie.map.NoArg


// label, province, lon, lat

@NoArg
data class CityPositions(
        val positions: List<CityPosition>
)

@NoArg
data class CityPosition(
        val label: String,
        val province: String,
        val lon: Double,
        val lat: Double
)


// release_date, release_hour, city_code,
// city_label, AQI, PM25, PM25_24h, PM10,
// PM10_24h, SO2, SO2_24h, NO2, NO2_24h,
// O3, O3_24h, O3_8h, O3_8h_24h, CO, CO_24h,
// update_time, temperature, humidity,
// wind_level, weather_condition,
// somatosensory_temperature,
// wind_speed, atmospheric_pressure,
// station_height, rainfall, wind_direction,
// UV_intensity, visibility, windDir

@NoArg
data class CityCondition(
        val release_date: String?,
        val release_hour: Int?,
        val city_code: String?,
        val AQI: Double?,
        val PM25: Double?,
        val PM25_24h: Double?,
        val PM10: Double?,
        val PM10_24h: Double?,
        val SO2: Double?,
        val SO2_24h: Double?,
        val NO2: Double?,
        val NO2_24h: Double?,
        val O3: Double?,
        val O3_24h: Double?,
        val O3_8h: Double?,
        val O3_8h_24h: Double?,
        val CO: Double?,
        val CO_24h: Double?,
        val update_time: String?,
        val temperature: Double?,
        val humidity: Double?,
        val wind_level: Double?,
        val weather_condition: String?,
        val somatosensory_temperature: Double?,
        val wind_speed: Double?,
        val atmospheric_pressure: Double?,
        val station_height: Double?,
        val rainfall: Double?,
        val wind_direction: Double?,
        val UV_intensity: Double?,
        val visibility: Double?,
        val windDir: String?
)
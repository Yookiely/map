package com.yookie.map.bean

import com.yookie.map.NoArg

@NoArg
data class IsobaricLine(
        val type: String,
        val features: List<Feature>
)

@NoArg
data class Feature(
        val type: String,
        val properties: Property,
        val geometry: Geometry
)

@NoArg
data class Property(
        val temperature: Double
)

@NoArg
data class Geometry(
        val type: String,
        val coordinates: List<Double>
)

/*
SELECT city_label, lon, lat, atmospheric_pressure, release_date
FROM city_position
left join city_condition
on city_position.label = city_condition.city_label
where release_date = ""
* */
// label, province, lon, lat,
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
data class IsobaricLineData(
        val lon: Double,
        val lat: Double,
        val release_date: String,
        val city_label: String,
        val atmospheric_pressure: Double
)
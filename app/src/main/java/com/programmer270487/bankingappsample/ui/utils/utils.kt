package com.programmer270487.bankingappsample.ui.utils

fun getFormattedLocation(latitude: Double, longitude: Double): String {
    val lat = if (latitude >= 0) "${latitude}° N" else "${-latitude}° S"
    val lon = if (longitude >= 0) "${longitude}° E" else "${-longitude}° W"

    return "$lat, $lon"
}
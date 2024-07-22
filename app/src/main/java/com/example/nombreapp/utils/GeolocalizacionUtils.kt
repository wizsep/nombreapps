package com.example.nombreapp.utils

import android.content.Context
import android.location.Geocoder
import android.location.Location
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import java.util.Locale

@Composable
fun getCurrentLocation(): Location? {
    val context = LocalContext.current
    val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as android.location.LocationManager
    return try {
        locationManager.getLastKnownLocation(android.location.LocationManager.GPS_PROVIDER)
    } catch (e: SecurityException) {
        null
    }
}

fun getAddressFromLocation(context: Context, location: Location): String {
    val geocoder = Geocoder(context, Locale.getDefault())
    val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)
    return if (addresses.isNotEmpty()) addresses[0].getAddressLine(0) else ""
}

package com.example.nombreapp.network

import retrofit2.http.GET

interface ApiService {
    @GET("api")
    suspend fun getTasaCambio(): TasaCambioResponse
}

data class TasaCambioResponse(
    val valor: Float
)

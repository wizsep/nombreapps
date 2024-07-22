package com.example.nombreapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lugares")
data class Lugar(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val imagenUrl: String,
    val latitud: Double,
    val longitud: Double,
    val orden: Int,
    val costoAlojamiento: Int,
    val costoTraslados: Int,
    val comentarios: String
)

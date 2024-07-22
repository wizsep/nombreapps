package com.example.nombreapp.repository

import androidx.lifecycle.LiveData
import com.example.nombreapp.Lugar
import com.example.nombreapp.LugarDao

class LugarRepository(private val lugarDao: LugarDao) {
    val allLugares: LiveData<List<Lugar>> = lugarDao.getAll()

    suspend fun insert(lugar: Lugar) {
        lugarDao.insert(lugar)
    }

    suspend fun update(lugar: Lugar) {
        lugarDao.update(lugar)
    }

    suspend fun delete(lugar: Lugar) {
        lugarDao.delete(lugar)
    }
}
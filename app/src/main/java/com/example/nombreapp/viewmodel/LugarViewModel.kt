package com.example.nombreapp.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.nombreapp.AppDatabase
import com.example.nombreapp.Lugar
import com.example.nombreapp.repository.LugarRepository
import kotlinx.coroutines.launch

class LugarViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: LugarRepository
    val lugares: LiveData<List<Lugar>>

    init {
        val lugarDao = AppDatabase.getDatabase(application).lugarDao()
        repository = LugarRepository(lugarDao)
        lugares = repository.allLugares
    }

    fun insert(lugar: Lugar) = viewModelScope.launch {
        repository.insert(lugar)
    }

    fun update(lugar: Lugar) = viewModelScope.launch {
        repository.update(lugar)
    }

    fun delete(lugar: Lugar) = viewModelScope.launch {
        repository.delete(lugar)
    }
}
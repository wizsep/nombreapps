package com.example.nombreapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface LugarDao {
    @Query("SELECT * FROM lugares ORDER BY orden ASC")
    fun getAll(): LiveData<List<Lugar>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(lugar: Lugar)

    @Update
    suspend fun update(lugar: Lugar)

    @Delete
    suspend fun delete(lugar: Lugar)
}
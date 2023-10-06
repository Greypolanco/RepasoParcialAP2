package com.example.repasoap2.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.repasoap2.data.local.entity.Prestamo
import kotlinx.coroutines.flow.Flow

@Dao
interface PrestamoDao {
    @Upsert
    suspend fun save(prestamo: Prestamo)

    @Delete
    suspend fun deleted(prestamo: Prestamo)

    @Query("SELECT * FROM Prestamo WHERE prestamoId= :id LIMIT 1")
    suspend fun find(id : Int)

    @Query("SELECT * FROM Prestamo ORDER BY concepto")
    fun getAll() : Flow<List<Prestamo>>
}
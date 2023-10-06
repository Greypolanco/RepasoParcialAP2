package com.example.repasoap2.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.repasoap2.data.local.entity.Personas
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonasDao {
    @Upsert
    suspend fun save(personas: Personas)

    @Delete
    suspend fun deleted(personas: Personas)

    @Query("SELECT * FROM Personas WHERE personaId= :id LIMIT 1")
    suspend fun find(id : Int)

    @Query("SELECT * FROM Personas ORDER BY nombre")
    fun getAll(): Flow<List<Personas>>
}
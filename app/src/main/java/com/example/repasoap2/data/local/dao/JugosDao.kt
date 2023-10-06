package com.example.repasoap2.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import com.example.repasoap2.data.local.entity.Jugos
import kotlinx.coroutines.flow.Flow

@Dao
interface JugosDao {

    @Upsert
    suspend fun save(jugos: Jugos)

    @Delete
    suspend fun deleted(jugos: Jugos)

    @Query("SELECT * FROM Jugos WHERE jugoId = :id LIMIT 1")
    suspend fun find(id : Int)

    @Query("SELECT * FROM Jugos ORDER BY nombre")
    fun getAll(): Flow<List<Jugos>>
}
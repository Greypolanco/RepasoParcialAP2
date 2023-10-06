package com.example.repasoap2.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.repasoap2.data.local.entity.Ticket
import kotlinx.coroutines.flow.Flow

@Dao
interface TicketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(ticket: Ticket)

    @Delete
    suspend fun deleted(ticket: Ticket)

    @Query("SELECT * FROM Ticket WHERE ticketId= :id LIMIT 1")
    suspend fun find(id : Int)

    @Query("SELECT * FROM Ticket ORDER BY nombre")
    fun getAll() : Flow<List<Ticket>>
}
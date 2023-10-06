package com.example.repasoap2.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Ticket")
data class Ticket(
    @PrimaryKey(autoGenerate = true)
    val ticketId : Int? = null,
    val nombre : String=""
)

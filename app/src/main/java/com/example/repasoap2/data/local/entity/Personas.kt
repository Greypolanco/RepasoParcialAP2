package com.example.repasoap2.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Personas")
data class Personas(
    @PrimaryKey(autoGenerate = true)
    val personaId : Int? = null,
    val nombre : String = ""
)

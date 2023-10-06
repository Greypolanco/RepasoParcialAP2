package com.example.repasoap2.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Jugos")
data class Jugos(
    @PrimaryKey(autoGenerate = true)
    val jugoId : Int?= null,
    var nombre : String = ""
)

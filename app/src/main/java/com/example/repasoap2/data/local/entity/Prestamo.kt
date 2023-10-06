package com.example.repasoap2.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Prestamo")
data class Prestamo(
    @PrimaryKey(autoGenerate = true)
    val prestamoId : Int? = null,
    var concepto : String ="",
    val monto : Double? = null
)

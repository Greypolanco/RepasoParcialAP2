package com.example.repasoap2.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.repasoap2.data.local.dao.JugosDao
import com.example.repasoap2.data.local.dao.PersonasDao
import com.example.repasoap2.data.local.dao.PrestamoDao
import com.example.repasoap2.data.local.dao.TicketDao
import com.example.repasoap2.data.local.entity.Jugos
import com.example.repasoap2.data.local.entity.Personas
import com.example.repasoap2.data.local.entity.Prestamo
import com.example.repasoap2.data.local.entity.Ticket

@Database(
    entities = [Jugos::class, Personas::class, Ticket::class, Prestamo::class],
    version = 4,
    exportSchema = false
)
abstract class DataBase : RoomDatabase(){

    abstract fun jugosDao(): JugosDao
    abstract  fun personasDao() : PersonasDao
    abstract fun ticketDao() : TicketDao
    abstract fun prestamoDao() :PrestamoDao
}
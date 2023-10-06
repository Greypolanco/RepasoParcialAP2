package com.example.repasoap2.data.repository

import com.example.repasoap2.data.DataBase
import com.example.repasoap2.data.local.dao.JugosDao
import com.example.repasoap2.data.local.entity.Jugos
import javax.inject.Inject

class JugoRepository @Inject constructor(
    private val jugosDao: JugosDao
) {
    suspend fun saveJugos(jugos: Jugos) = jugosDao.save(jugos)
    suspend fun deletedJugos(jugos: Jugos) = jugosDao.deleted(jugos)
    suspend fun findJugos(id : Int) = jugosDao.find(id)
    fun getAllJugos() = jugosDao.getAll()

}
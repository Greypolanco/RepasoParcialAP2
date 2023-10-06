package com.example.repasoap2.data.repository

import com.example.repasoap2.data.DataBase
import com.example.repasoap2.data.local.dao.PrestamoDao
import com.example.repasoap2.data.local.entity.Prestamo
import javax.inject.Inject

class PrestamoRepository @Inject constructor(
    private val prestamoDao: PrestamoDao
) {
    suspend fun savePrestamo(prestamo: Prestamo) = prestamoDao.save(prestamo)
    suspend fun deletedPrestamo(prestamo: Prestamo) = prestamoDao.deleted(prestamo)
    suspend fun findPrestamo(id : Int) = prestamoDao.find(id)
    fun getAllPrestamo() = prestamoDao.getAll()
}
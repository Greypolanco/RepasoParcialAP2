package com.example.repasoap2.data.repository

import com.example.repasoap2.data.DataBase
import com.example.repasoap2.data.local.dao.PersonasDao
import com.example.repasoap2.data.local.entity.Personas
import javax.inject.Inject

class PersonaRepository @Inject constructor(
    private val personasDao: PersonasDao
) {
    suspend fun savePersona(personas: Personas) = personasDao.save(personas)
    suspend fun deletedPersona(personas: Personas) = personasDao.deleted(personas)
    suspend fun findPersona(id : Int) = personasDao.find(id)
    fun getAllPersona() = personasDao.getAll()
}
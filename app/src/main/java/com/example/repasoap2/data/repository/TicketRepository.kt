package com.example.repasoap2.data.repository

import com.example.repasoap2.data.DataBase
import com.example.repasoap2.data.local.dao.TicketDao
import com.example.repasoap2.data.local.entity.Ticket
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TicketRepository @Inject constructor(
    private val ticketDao: TicketDao
) {
    suspend fun saveTicket(ticket: Ticket) = ticketDao.save(ticket)
    suspend fun deletedTicket(ticket: Ticket) = ticketDao.deleted(ticket)
    suspend fun findTicket(id : Int) = ticketDao.find(id)
    fun getAllTickets(): Flow<List<Ticket>>{
        return ticketDao.getAll()
    }
}
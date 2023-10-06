package com.example.repasoap2.ui.Ticket

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repasoap2.data.DataBase
import com.example.repasoap2.data.local.entity.Ticket
import com.example.repasoap2.data.repository.JugoRepository
import com.example.repasoap2.data.repository.TicketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TicketViewModel @Inject constructor(
    private val ticketRepository: TicketRepository
) : ViewModel() {
    var nombre by mutableStateOf("")

    val ticket: StateFlow<List<Ticket>> = ticketRepository.getAllTickets().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )

    fun saveTicket(){
        viewModelScope.launch {
            val ticket = Ticket(
                nombre = nombre
            )
            if(invalid()){
                ticketRepository.saveTicket(ticket)
                clean()
            }
        }
    }

    fun save(){
        viewModelScope.launch {
            ticketRepository.saveTicket(
                Ticket(
                    nombre = nombre
                )
            )
            clean()
        }
    }
    private fun clean(){
        nombre = ""
    }

    private fun invalid(): Boolean{
        return !(nombre.isEmpty() || nombre.isBlank())
    }
}
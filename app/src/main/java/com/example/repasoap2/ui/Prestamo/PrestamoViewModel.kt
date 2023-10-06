package com.example.repasoap2.ui.Prestamo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repasoap2.data.DataBase
import com.example.repasoap2.data.local.entity.Prestamo
import com.example.repasoap2.data.repository.PrestamoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrestamoViewModel @Inject constructor(
    private val prestamoRepository: PrestamoRepository
): ViewModel() {
    var concepto by mutableStateOf("")
    var monto by mutableStateOf(0.00)

    val prestamo : StateFlow<List<Prestamo>> = prestamoRepository.getAllPrestamo().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )

    fun savePrestamo(){
        viewModelScope.launch {
            val prestamo = Prestamo(
                concepto = concepto,
                monto = monto
            )
            if(inValid()){
                prestamoRepository.savePrestamo(prestamo)
                clean()
            }
        }
    }// otra funcion

    fun save(){
        viewModelScope.launch {
            prestamoRepository.savePrestamo(
                Prestamo(
                    concepto = concepto,
                    monto = monto
                )
            )
        }
    }
    private fun clean(){
        concepto = ""
        monto = 0.00
    }

    private fun inValid(): Boolean{
        return !(concepto.isEmpty() || concepto.isBlank() || monto == 0.0)

    }
}
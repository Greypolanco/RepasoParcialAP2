package com.example.repasoap2.ui.Jugos


import android.opengl.ETC1.isValid
import androidx.compose.runtime.getValue//eso se importa
import androidx.compose.runtime.mutableStateOf//esto tambien con el mutable
import androidx.compose.runtime.setValue// este igual
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.repasoap2.data.DataBase
import com.example.repasoap2.data.local.entity.Jugos
import com.example.repasoap2.data.repository.JugoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JugosViewModel @Inject constructor(
    private val jugosRepository: JugoRepository
) : ViewModel() {

    var nombre by mutableStateOf("")

    val jugos: StateFlow<List<Jugos>> = jugosRepository.getAllJugos().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptyList()
    )

    fun saveJugos(){
        viewModelScope.launch {
            val jugos = Jugos(
                nombre = nombre
            )
            if(isValid()){
                jugosRepository.saveJugos(jugos)
                cleanFiel()
            }
        }
    } //otra funcion de guardar

    fun save(){
        viewModelScope.launch {
            jugosRepository.saveJugos(Jugos(
                nombre = nombre
            ))
        }
    }

    private fun cleanFiel(){
        nombre = ""
    }

    private fun isValid(): Boolean{
        return !(nombre.isEmpty() || nombre.isBlank())
    }
}
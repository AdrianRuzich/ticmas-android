package com.adrianruzich.comparar.view

import com.adrianruzich.comparar.model.Comparador
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val comparador: LiveData<Comparador> get() = _comparador
    private var _comparador = MutableLiveData(Comparador("", "", true))

    fun compararCadenas(string1: String, string2: String) {
        viewModelScope.launch {
            _comparador.value = Comparador(string1, string2,string1 == string2)
        }
    }
}

package com.example.mvvm_firebase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_firebase.model.Conta
import com.example.mvvm_firebase.repository.ContaRepository

class ContentViewModel : ViewModel() {

    private val _contas = MutableLiveData<List<Conta>>()
    val contas: LiveData<List<Conta>> = _contas

    private val _error = MutableLiveData<String>()
    val error : LiveData<String> = _error

    val contaRepository = ContaRepository()

    fun fetchContas(){
        contaRepository.fethContas { contas, error ->
            if (error != null){
                _error.value = error
            } else{
                _contas.value = contas
            }
        }
    }

}
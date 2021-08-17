package com.example.mvvm_firebase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_firebase.repository.AuthenticationRepoository
import com.google.firebase.auth.FirebaseUser

class SignUpViewModel : ViewModel() {

    private val _user = MutableLiveData<FirebaseUser?>()//para manipulacao interna
    val user : LiveData<FirebaseUser?> = _user//para manipulacao externa

    private val repository = AuthenticationRepoository()//

    fun creatNewAccontou(email: String, password: String){
    repository.creatAccontWithEmailPassword(email, password){
        _user.value = it
    }
    }


}
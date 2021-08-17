package com.example.mvvm_firebase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_firebase.repository.AuthenticationRepoository
import com.google.firebase.auth.FirebaseUser

class SigninViewModel : ViewModel() {

    private val _user = MutableLiveData<FirebaseUser?>()
    val user : LiveData<FirebaseUser?> = _user

    private val _error = MutableLiveData<String>()
    val error : LiveData<String> = _error

    private val authenticationRepoository = AuthenticationRepoository()

    fun singIn(email: String, password: String){
        authenticationRepoository.singWithEmailPassword(email, password){firebaseUser, error ->
            if (firebaseUser != null){
                _user.value = firebaseUser
            } else{
                _error.value = error ?:"Erro desconhecido"
            }
        }
    }

}
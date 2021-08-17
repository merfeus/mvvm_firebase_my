package com.example.mvvm_firebase.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthenticationRepoository {

    private val auth = FirebaseAuth.getInstance()

    fun singWithEmailPassword(
        email: String,
        password: String,
        callback: (FirebaseUser?, String?) -> Unit
    ) {
        val task = auth.signInWithEmailAndPassword(email, password)
        task.addOnSuccessListener { authResult ->
            if (authResult.user != null) {
                callback(authResult.user, null)
            } else {
                callback(null, "Erro no login")
            }
        }
        task.addOnFailureListener {
            callback(null, it.message)
        }
    }

    fun creatAccontWithEmailPassword(
        email: String,
        password: String,
        callback: (FirebaseUser?) -> Unit
    ) {
        val tesk = auth.createUserWithEmailAndPassword(email, password)
        tesk.addOnSuccessListener { authResult ->
            callback(authResult.user)
        }
    }
}
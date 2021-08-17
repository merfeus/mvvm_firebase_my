package com.example.mvvm_firebase.repository

import com.example.mvvm_firebase.model.Conta
import com.google.firebase.firestore.FirebaseFirestore


class ContaRepository {

    private val dataBase = FirebaseFirestore.getInstance()

    fun fethContas(callback: (List<Conta>?, String?) ->Unit){
        dataBase.collection("contas")
            .get()
            .addOnSuccessListener { result ->
                val listOf = arrayListOf<Conta>()
                result.forEach {
                    val conta = Conta.fromData(snapshot = it)
                    listOf.add(conta)
                }
                callback(listOf, null)
            }
            .addOnFailureListener { exception ->
                callback(null, exception.message)
            }
    }
}
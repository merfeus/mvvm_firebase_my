package com.example.mvvm_firebase.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import com.example.mvvm_firebase.MainActivity
import com.example.mvvm_firebase.R
import com.example.mvvm_firebase.utils.replaceView
import com.example.mvvm_firebase.viewmodel.SignUpViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseUser

class SignUpFragment : Fragment(R.layout.signup_fragment) {

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var viewModel: SignUpViewModel

    private val observerNewUser = Observer<FirebaseUser?> {
        Snackbar.make(requireView(), "Useria criado com sucesso!", Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)//referencia do view model
        viewModel.user.observe(viewLifecycleOwner, observerNewUser)//referencia do user externo, dentro do view model

        view.findViewById<Button>(R.id.buttonEntrar).setOnClickListener {
            val inputEmail = view.findViewById<EditText>(R.id.editTextEmail)
            val inputPassword = view.findViewById<EditText>(R.id.editTextPassword)

            if (!inputEmail.text.isNullOrEmpty() && !inputPassword.text.isNullOrEmpty()) {
                viewModel.creatNewAccontou(
                    inputEmail.text.toString(),
                    inputPassword.text.toString()
                )
            }
        }

        view.findViewById<View>(R.id.backButton).setOnClickListener {
            (requireActivity() as? MainActivity)?.replaceView(SignInFragment.newInstance())
        }
    }

}
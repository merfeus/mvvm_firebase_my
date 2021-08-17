package com.example.mvvm_firebase.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.mvvm_firebase.MainActivity
import com.example.mvvm_firebase.R
import com.example.mvvm_firebase.utils.replaceView
import com.example.mvvm_firebase.utils.setupSnackbar
import com.example.mvvm_firebase.viewmodel.SigninViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseUser

class SignInFragment : Fragment(R.layout.signin_fragment) {

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var viewModel: SigninViewModel

    private val observerUser = Observer<FirebaseUser?>{
        requireActivity().replaceView(ContentFragment.newInstance())
    }

    private val observerError = Observer<String> {
        Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(SigninViewModel::class.java)

        viewModel.error.observe(viewLifecycleOwner, observerError)
        viewModel.user.observe(viewLifecycleOwner, observerUser)

        view.findViewById<Button>(R.id.loginButton).setOnClickListener {
            val inputEmail = view.findViewById<EditText>(R.id.inputEmailEditText)
            val inputPassword = view.findViewById<EditText>(R.id.inputPasswordEditText)
            if (!inputEmail.text.isNullOrEmpty() && !inputPassword.text.isNullOrEmpty()) {
                viewModel.singIn(
                    inputEmail.text.toString(),
                    inputPassword.text.toString()
                )
            }
        }

        view.findViewById<TextView>(R.id.newAccountTextView).setOnClickListener {
            (requireActivity() as? MainActivity)?.replaceView(SignUpFragment.newInstance())
        }
    }

}


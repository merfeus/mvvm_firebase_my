package com.example.mvvm_firebase.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_firebase.MainActivity
import com.example.mvvm_firebase.R
import com.example.mvvm_firebase.adapter.ContasAdapter
import com.example.mvvm_firebase.model.Conta
import com.example.mvvm_firebase.utils.replaceView
import com.example.mvvm_firebase.viewmodel.ContentViewModel

class ContentFragment : Fragment(R.layout.content_fragment) {

    companion object {
        fun newInstance() = ContentFragment()
    }

    private lateinit var viewModel: ContentViewModel
    private lateinit var recyclerView: RecyclerView
    private val adapter = ContasAdapter()

    val observerContas = Observer<List<Conta>> {
        adapter.refresh(it)
    }

    val observerError = Observer<String> {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ContentViewModel::class.java)


        recyclerView = view.findViewById<RecyclerView>(R.id.contasRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        viewModel.error.observe(viewLifecycleOwner, observerError)
        viewModel.contas.observe(viewLifecycleOwner, observerContas)

        viewModel.fetchContas()

        view.findViewById<View>(R.id.backButton).setOnClickListener {
            (requireActivity() as? MainActivity)?.replaceView(SignInFragment.newInstance())
        }

    }

}
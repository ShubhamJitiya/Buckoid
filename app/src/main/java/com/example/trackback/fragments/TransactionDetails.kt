package com.example.trackback.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.trackback.R
import com.example.trackback.databinding.FragmentTransactionDetailsBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class TransactionDetails : Fragment() {

    val transaction by navArgs<TransactionDetailsArgs>()
    lateinit var binding: FragmentTransactionDetailsBinding
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTransactionDetailsBinding.inflate(inflater, container, false)

        val bottomNav: BottomNavigationView = requireActivity().findViewById(R.id.bottomNavigation)
        bottomNav.visibility = View.GONE

        binding.title.text = transaction.data.title
        binding.amount.text= "₹${transaction.data.amount}"
        binding.category.text = transaction.data.category
        binding.date.text = transaction.data.date
        binding.note.text = transaction.data.note

        binding.back.setOnClickListener { Navigation.findNavController(binding.root).navigate(R.id.action_transactionDetails_to_dashboard2) }

        val argument = TransactionDetailsDirections.actionTransactionDetailsToAddTransaction(transaction.data,true)
        binding.edit.setOnClickListener { Navigation.findNavController(binding.root).navigate(argument) }
        return binding.root
    }


}
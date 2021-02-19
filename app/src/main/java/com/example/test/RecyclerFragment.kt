package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.test.adapters.RecyclerAdapter
import com.example.test.databinding.FragmentRecyclerViewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job

@AndroidEntryPoint
class RecyclerFragment  : Fragment() {

    private val adapter = RecyclerAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        context ?: return binding.root

        binding.recyclerList.adapter = adapter

        return binding.root
    }
}
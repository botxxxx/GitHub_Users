package com.example.test

import android.os.*
import android.view.*
import androidx.fragment.app.*
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.test.adapters.*
import com.example.test.databinding.*
import com.example.test.viewmodels.*
import dagger.hilt.android.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecyclerListFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerViewBinding
    private val viewModel: RecyclerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        val adapter = RecyclerAdapter()
        binding.recyclerList.adapter = adapter

        return binding.root
    }
}
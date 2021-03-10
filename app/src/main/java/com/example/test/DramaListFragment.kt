package com.example.test

import android.os.*
import android.view.*
import androidx.fragment.app.*
import androidx.lifecycle.lifecycleScope
import com.example.test.adapters.*
import com.example.test.databinding.FragmentDramaViewBinding
import com.example.test.viewmodels.*
import dagger.hilt.android.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DramaListFragment : Fragment() {
    private var searchJob: Job? = null
    private val adapter = DramaAdapter()
    private val viewModel: DramaListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDramaViewBinding.inflate(inflater, container, false)
        context ?: return binding.root
        binding.dramaList.adapter = adapter

        subscribeUi()

        return binding.root
    }

    private fun subscribeUi() {
        // Make sure we cancel the previous job before creating a new one
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            viewModel.getResult().collectLatest {
                adapter.submitData(it)
            }
        }
    }
}
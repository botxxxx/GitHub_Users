package com.example.test

import android.os.*
import android.view.*
import androidx.fragment.app.*
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.test.databinding.FragmentDetailViewBinding
import com.example.test.viewmodels.DetailViewModel
import dagger.hilt.android.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserDetailFragment : Fragment() {

    private val args: UserDetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailViewBinding
    private val viewModel: DetailViewModel by viewModels()
    private var searchJob: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailViewBinding.inflate(inflater, container, false)
        context ?: return binding.root
        binding.setClickListener {
            activity?.onBackPressed()
        }

        subscribeUi(args.login)
        return binding.root
    }

    private fun subscribeUi(login: String) {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            binding.detail = viewModel.getResult(login)
        }
    }
}
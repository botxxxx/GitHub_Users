package com.example.test

import android.os.*
import android.view.*
import androidx.fragment.app.*
import com.example.test.adapters.*
import com.example.test.databinding.*
import com.example.test.viewmodels.*
import dagger.hilt.android.*

@AndroidEntryPoint
class UserListFragment : Fragment() {

    private val viewModel: UserListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = UsersAdapter()
        binding.recyclerList.adapter = adapter
        subscribeUi(adapter)
        return binding.root
    }

    private fun subscribeUi(adapter: UsersAdapter) {
        viewModel.users.observe(viewLifecycleOwner) { users ->
            adapter.submitList(users)
        }
    }
}
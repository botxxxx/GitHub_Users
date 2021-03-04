package com.example.test

import android.content.Context
import android.os.*
import android.util.Log
import android.view.*
import androidx.fragment.app.*
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.test.adapters.*
import com.example.test.databinding.FragmentRecyclerViewBinding
import com.example.test.viewmodels.*
import dagger.hilt.android.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserListFragment : Fragment() {
    private lateinit var binding: FragmentRecyclerViewBinding
    private val adapter = UsersAdapter()
    private val viewModel: UserListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        context ?: return binding.root
        binding.recyclerList.adapter = adapter

        subscribeUi(binding.root.context)
        initSwipeToDelete()
        return binding.root
    }

    private fun subscribeUi(app: Context) {
        lifecycleScope.launch {
            viewModel.users.collectLatest {
                adapter.submitData(it)
            }
        }
    }

    private fun initSwipeToDelete() {
        ItemTouchHelper(object : ItemTouchHelper.Callback() {
            // enable the items to swipe to the left or right
            override fun getMovementFlags(
                recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder
            ): Int = makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

            override fun onMove(
                recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                (viewHolder as UsersAdapter.UserViewHolder).data?.let {
                    viewModel.remove(binding.root.context, it)
                    Log.d("com.example.kotlin", it.name)
                }
            }
        }).attachToRecyclerView(binding.recyclerList)
    }
}
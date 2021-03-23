package com.example.test

import android.os.*
import android.view.*
import androidx.fragment.app.*
import androidx.viewpager2.widget.ViewPager2
import com.example.test.adapters.*
import com.example.test.databinding.FragmentDetailViewBinding
import dagger.hilt.android.*

@AndroidEntryPoint
class UserDetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailViewBinding.inflate(inflater, container, false)
        context ?: return binding.root

        return binding.root
    }

}
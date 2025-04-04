package com.example.test

import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.test.databinding.FragmentDetailViewBinding
import com.example.test.viewmodels.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UserDetailFragment : Fragment() {

    private val args: UserDetailFragmentArgs by navArgs()
    private var binding: FragmentDetailViewBinding? = null
    private val viewModel: DetailViewModel by viewModels()
    private var searchJob: Job? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailViewBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onDestroyView() {
        searchJob?.cancel()
        binding = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.ivClose.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        viewModel.userDetail.observe(viewLifecycleOwner) {
            binding?.apply {
                tvName.text = it.name
                tvBio.text = it.bio
                tvLogin.text = it.login
                tvAdmin.isVisible = it.site_admin
                tvLocation.text = it.location
                setUrlSpan(it.blog)
                Glide.with(view.context)
                    .load(it.avatar_url)
                    .circleCrop()
                    .placeholder(R.drawable.github_b_24px)
                    .into(ivAvatar)
            }
        }
        subscribeUi(args.login)
    }

    private fun setUrlSpan(url: String?) {
        binding?.apply {
            url?.let {
                tvBlog.movementMethod = LinkMovementMethod.getInstance()
                tvBlog.autoLinkMask = Linkify.WEB_URLS
                tvBlog.text = Html.fromHtml(url, HtmlCompat.FROM_HTML_MODE_COMPACT)
            } ?: kotlin.run {
                ivLink.isVisible = false
                tvBlog.isVisible = false
            }
        }
    }

    private fun subscribeUi(login: String) {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            val detailData = viewModel.getResult(login)
            viewModel.userDetail.postValue(detailData)
        }
    }
}
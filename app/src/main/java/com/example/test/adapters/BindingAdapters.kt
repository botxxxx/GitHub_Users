package com.example.test.adapters

import android.os.Build
import android.text.Html
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.view.View
import android.widget.*
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.test.R

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(imageUrl)
            .centerCrop()
            .placeholder(R.drawable.github_b_24px)
            .into(view)
    }
}

@BindingAdapter("isAdmin")
fun bindIsAdmin(view: TextView, isGone: Boolean?) {
    if (isGone == null || !isGone) {
        view.visibility = View.GONE
    } else {
        view.visibility = View.VISIBLE
    }
}

@BindingAdapter("isHtml")
fun bindIsHtml(view: TextView, description: String?) {
    if (description != null) {
        view.movementMethod = LinkMovementMethod.getInstance()
        view.autoLinkMask = Linkify.WEB_URLS
        view.text = Html.fromHtml(description, HtmlCompat.FROM_HTML_MODE_COMPACT)
    } else {
        view.text = ""
    }
}
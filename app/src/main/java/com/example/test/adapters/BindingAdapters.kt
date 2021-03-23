package com.example.test.adapters

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
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

@BindingAdapter("detailsFromUrl")
fun bindDetailsFromUrl(view: RelativeLayout, Url: String?) {
    if (!Url.isNullOrEmpty()) {
        val dialogView: View =
            LayoutInflater.from(view.context).inflate(R.layout.fragment_detail_view, null)
        val dialog = AlertDialog.Builder(view.context, R.style.Theme_AppCompat_NoActionBar)
            .setView(dialogView).setCancelable(true).create()
        dialogView.findViewById<View>(R.id.close_button).setOnClickListener {
            dialog.dismiss()
        }
    }
}
package com.example.test.viewmodels;

import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.test.R;

public class BindingAdapters {

    @BindingAdapter("imageFromUrl")
    public static void bindImageFromUrl(ImageView view, String imageUrl) {
        if (imageUrl != null && !imageUrl.isEmpty()) {
            Glide.with(view.getContext())
                    .load(imageUrl)
                    .circleCrop()
                    .placeholder(R.drawable.github_b_24px)
                    .error(R.drawable.github_b_24px)
                    .into(view);
        }
    }

    @BindingAdapter("isAdmin")
    public static void bindIsAdmin(TextView view, Boolean isGone) {
        if (isGone == null || !isGone) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
        }
    }

    @BindingAdapter("isHtml")
    public static void bindIsHtml(TextView view, String description) {
        if (description != null) {
            view.setMovementMethod(LinkMovementMethod.getInstance());
            view.setAutoLinkMask(Linkify.WEB_URLS);
            view.setText(Html.fromHtml(description, Html.FROM_HTML_MODE_COMPACT));
        } else {
            view.setText("");
        }
    }
}
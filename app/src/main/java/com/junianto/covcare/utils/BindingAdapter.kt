package com.junianto.covcare.utils

import android.webkit.WebView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.junianto.covcare.R

@BindingAdapter(value = ["imageUrl"], requireAll = false)
fun loadNewsImage(view: ImageView, imageUrl: String?) {
    Glide.with(view.context)
        .load(imageUrl)
        .error(R.drawable.ic_broken_image)
        .into(view)
}

@BindingAdapter("loadUrl")
fun WebView.setUrl(url: String) {
    this.loadUrl(url)
}
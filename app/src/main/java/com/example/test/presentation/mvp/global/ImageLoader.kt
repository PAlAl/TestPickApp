package com.example.test.presentation.mvp.global

import android.net.Uri
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.test.R

object ImageLoader {

    private fun getImageRequestOptions(): RequestOptions {
        return RequestOptions()
                .timeout(10000)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.loading_error)
    }

    fun simpleLoad(view: View, url: String, imageView: ImageView) {
        Glide
                .with(view)
                .setDefaultRequestOptions(getImageRequestOptions())
                .load(Uri.parse(url))
                .into(imageView)
    }
}
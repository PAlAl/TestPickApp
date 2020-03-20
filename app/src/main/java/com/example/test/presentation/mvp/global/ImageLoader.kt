package com.example.test.presentation.mvp.global

import android.net.Uri
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.test.R

object ImageLoader {

    private const val defaultRequestTimeout = 10000

    private fun getImageRequestOptions(requestTimeOut: Int): RequestOptions {
        return RequestOptions()
                .timeout(requestTimeOut)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.loading_error)
    }

    fun simpleLoad(view: View, url: String, imageView: ImageView, requestTimeOut: Int = defaultRequestTimeout) {
        Glide
                .with(view)
                .setDefaultRequestOptions(getImageRequestOptions(requestTimeOut))
                .load(Uri.parse(url))
                .into(imageView)
    }
}
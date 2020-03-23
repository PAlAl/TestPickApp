package com.example.test.presentation.ui.views.postDetail.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.test.presentation.mvp.global.ImageLoader
import kotlinx.android.synthetic.main.item_post_details_image.view.*

class PostsDetailsImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun init(imageUrl: String) {
        ImageLoader.simpleLoad(itemView, imageUrl, itemView.post_details_image)
    }
}
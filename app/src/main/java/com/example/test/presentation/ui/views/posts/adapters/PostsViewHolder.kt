package com.example.test.presentation.ui.views.posts.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.test.presentation.ui.views.posts.models.PostViewModel
import kotlinx.android.synthetic.main.item_post.view.*

class PostsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun init(model: PostViewModel, onItemClick: (Int) -> Unit) {
        with(view) {
            post_item_title.text = model.text

            setOnClickListener { onItemClick(model.id) }
        }
    }
}
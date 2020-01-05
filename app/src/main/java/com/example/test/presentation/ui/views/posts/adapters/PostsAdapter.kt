package com.example.test.presentation.ui.views.posts.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.presentation.mvp.presenters.posts.PostsPresenter
import com.example.test.presentation.ui.views.posts.models.PostViewModel

class PostsAdapter(var items: List<PostViewModel>, val presenter: PostsPresenter) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_post, parent, false)

        return PostsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder: PostsViewHolder = holder as PostsViewHolder
        viewHolder.init(items[position], presenter.onItemClick)
    }

    override fun getItemCount() = items.size

    override fun getItemId(position: Int): Long {
        return items[position].id.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}
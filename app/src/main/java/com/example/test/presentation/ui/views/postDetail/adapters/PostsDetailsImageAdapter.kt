package com.example.test.presentation.ui.views.postDetail.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R

class PostsDetailsImageAdapter(var items: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post_details_image, parent, false)

        return PostsDetailsImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder: PostsDetailsImageViewHolder = holder as PostsDetailsImageViewHolder
        viewHolder.init(items[position])
    }

    override fun getItemCount() = items.size

    override fun getItemId(position: Int): Long {
        return items[position].hashCode().toLong()
    }
}
package com.example.test.presentation.ui.views.postDetail.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R

class PostsDetailsImageAdapter(private var items: ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

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

    fun updateData(newItems: List<String>) {
        val diffCallback = PostsDetailsImageDiffCallback(this.items, newItems)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.items.clear()
        this.items.addAll(newItems)
        diffResult.dispatchUpdatesTo(this)
    }

    private class PostsDetailsImageDiffCallback(private val oldImages: List<String>, private val newImages: List<String>) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldImages.size
        override fun getNewListSize(): Int = newImages.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldImages[oldItemPosition] == newImages[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldImages[oldItemPosition] == newImages[newItemPosition]
        }
    }
}
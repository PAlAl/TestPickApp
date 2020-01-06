package com.example.test.presentation.ui.views.posts.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.example.test.presentation.ui.views.posts.models.PostViewModel
import kotlinx.android.synthetic.main.item_post.view.*

class PostsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    private val defaultTextMaxLines: Int = 2

    fun init(model: PostViewModel, onItemClick: (Int) -> Unit, onExpandCollapseClick: (Int) -> Unit) {
        with(view) {
            item_post_title.text = model.title
            item_post_text.text = model.text
            item_post_likes.text = model.likesCount.toString()
            item_post_date.text = model.dateString

            if (model.isExpandText) {
                item_post_text.maxLines = Int.MAX_VALUE
                item_post_expand_collapse_title.text = view.context.getText(R.string.posts_menu_item_collapse_title)
                item_post_expand_collapse_img.setImageResource(R.drawable.ic_collapse)
            } else {
                item_post_text.maxLines = defaultTextMaxLines
                item_post_expand_collapse_title.text = view.context.getText(R.string.posts_menu_item_expand_title)
                item_post_expand_collapse_img.setImageResource(R.drawable.ic_expand)
            }

            setOnClickListener { onItemClick(model.id) }
            item_post_expand_collapse_container.setOnClickListener { onExpandCollapseClick(model.id) }
        }
    }
}
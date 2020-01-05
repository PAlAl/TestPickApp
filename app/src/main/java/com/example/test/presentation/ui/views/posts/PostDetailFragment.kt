package com.example.test.presentation.ui.views.posts

import android.os.Bundle
import android.view.*
import com.example.test.R
import com.example.test.presentation.ui.views.global.AppToolbarFragment

class PostDetailFragment : AppToolbarFragment() {
    override val layoutRes: Int = R.layout.fragment_post_detail
    override val appToolbarTitleId: Int = R.string.post_detail_app_bar_title
    override val isAppToolbarHomeAsUpEnabled:Boolean = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setHasOptionsMenu(true)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val a: Int = arguments?.let {
            val postDetailArgs = PostDetailFragmentArgs.fromBundle(it)
            postDetailArgs.postId
        } ?: 0
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }
}
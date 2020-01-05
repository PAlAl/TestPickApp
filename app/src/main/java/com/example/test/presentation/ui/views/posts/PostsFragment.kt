package com.example.test.presentation.ui.views.posts

import android.os.Bundle
import android.view.*
import androidx.navigation.fragment.findNavController
import com.example.test.R
import com.example.test.presentation.mvp.presenters.posts.IPostsView
import com.example.test.presentation.mvp.presenters.posts.PostsPresenter
import com.example.test.presentation.ui.views.global.AppToolbarFragment
import com.example.test.presentation.ui.views.posts.adapters.PostsAdapter
import com.example.test.presentation.ui.views.posts.models.PostViewModel
import kotlinx.android.synthetic.main.fragment_posts.*
import moxy.presenter.InjectPresenter

class PostsFragment : AppToolbarFragment(), IPostsView {
    override val layoutRes: Int = R.layout.fragment_posts
    override val appToolbarTitleId: Int = R.string.posts_app_bar_title

    @InjectPresenter
    lateinit var presenter: PostsPresenter

    private lateinit var adapter: PostsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setHasOptionsMenu(true)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PostsAdapter(arrayListOf(), presenter)
        adapter.setHasStableIds(true)
        posts_recycler_view.adapter = adapter
        posts_recycler_view.clipToPadding = false
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun showBlockingProgress(isShow: Boolean) {
        showProgressDialog(isShow)
    }

    override fun setPosts(posts: List<PostViewModel>) {
        if (posts.isEmpty()) {
            posts_recycler_view.visibility = View.GONE
            posts_empty_title.visibility = View.VISIBLE
        } else {
            posts_empty_title.visibility = View.GONE
            posts_recycler_view.visibility = View.VISIBLE
            adapter.items = posts
            adapter.notifyDataSetChanged()
        }
    }
}
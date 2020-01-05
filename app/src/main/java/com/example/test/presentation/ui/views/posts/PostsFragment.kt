package com.example.test.presentation.ui.views.posts

import android.os.Bundle
import android.view.*
import androidx.navigation.fragment.findNavController
import com.example.test.R
import com.example.test.presentation.mvp.presenters.posts.IPostsView
import com.example.test.presentation.mvp.presenters.posts.PostsPresenter
import com.example.test.presentation.ui.views.global.AppToolbarFragment
import kotlinx.android.synthetic.main.fragment_posts.*
import moxy.presenter.InjectPresenter

class PostsFragment : AppToolbarFragment(), IPostsView {
    override val layoutRes: Int = R.layout.fragment_posts
    override val appToolbarTitleId: Int = R.string.posts_app_bar_title

    @InjectPresenter
    lateinit var presenter: PostsPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setHasOptionsMenu(true)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lists.setOnClickListener {
            val action = PostsFragmentDirections.actionPostsFragmentToPostDetailFragment(1)
            findNavController().navigate(action)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun showBlockingProgress(isShow: Boolean) {
        showProgressDialog(isShow)
    }
}
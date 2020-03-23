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
    private var isNeedClearSorting: Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setHasOptionsMenu(true)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PostsAdapter(arrayListOf(), presenter.onItemClick, presenter.onExpandCollapseItemClick)
        adapter.setHasStableIds(true)
        posts_recycler_view.adapter = adapter
        posts_recycler_view.clipToPadding = false
        posts_recycler_view.setHasFixedSize(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.posts_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sort_by_date -> {
                if (!item.isChecked) {
                    item.isChecked = true
                    presenter.onSortByDateClick()
                }
                true
            }
            R.id.sort_by_rank -> {
                if (!item.isChecked) {
                    item.isChecked = true
                    presenter.onSortByRankClick()
                }
                true
            }
            R.id.sort_clear -> {
                isNeedClearSorting = true
                presenter.onSortClearClick()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        if (isNeedClearSorting) {
            menu.findItem(R.id.sort_cleared).isChecked = true
            isNeedClearSorting = false
        }
        super.onPrepareOptionsMenu(menu)
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

    override fun openPostDetail(postId: Int) {
        findNavController().navigate(PostsFragmentDirections.actionPostsFragmentToPostDetailFragment(postId))
    }
}
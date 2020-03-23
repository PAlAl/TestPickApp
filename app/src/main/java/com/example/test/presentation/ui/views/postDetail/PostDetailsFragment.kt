package com.example.test.presentation.ui.views.postDetail

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.test.R
import com.example.test.presentation.mvp.presenters.postDetail.IPostDetailsView
import com.example.test.presentation.mvp.presenters.postDetail.PostDetailsPresenter
import com.example.test.presentation.ui.views.global.AppToolbarFragment
import com.example.test.presentation.ui.views.postDetail.adapters.PostsDetailsImageAdapter
import com.example.test.presentation.ui.views.postDetail.models.PostDetailsViewModel
import kotlinx.android.synthetic.main.fragment_post_details.*
import moxy.presenter.InjectPresenter

class PostDetailsFragment : AppToolbarFragment(), IPostDetailsView {
    override val layoutRes: Int = R.layout.fragment_post_details
    override val appToolbarTitleId: Int = R.string.post_detail_app_bar_title
    override val isAppToolbarHomeAsUpEnabled: Boolean = true

    @InjectPresenter
    lateinit var presenter: PostDetailsPresenter

    private lateinit var imageAdapter: PostsDetailsImageAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setHasOptionsMenu(true)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postId: Int = arguments?.let {
            PostDetailsFragmentArgs.fromBundle(it).postId
        } ?: 0

        imageAdapter = PostsDetailsImageAdapter(arrayListOf())
        imageAdapter.setHasStableIds(true)
        post_details_images_recyclerview.adapter = imageAdapter
        post_details_images_recyclerview.clipToPadding = false
        post_details_images_recyclerview.setHasFixedSize(true)

        presenter.onViewCreated(postId)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                findNavController().popBackStack()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showBlockingProgress(isShow: Boolean) {
        showProgressDialog(isShow)
    }

    override fun setData(model: PostDetailsViewModel?) {
        if (model == null) {
            post_details_data_container.visibility = View.GONE
            post_details_empty_title.visibility = View.VISIBLE
        } else {
            post_details_empty_title.visibility = View.GONE
            post_details_data_container.visibility = View.VISIBLE
            renderDetails(model)
        }
    }

    private fun renderDetails(model: PostDetailsViewModel) {
        with(model) {
            post_details_title.text = title
            post_details_text.text = preparePostText(text)
            post_details_date.text = dateString
            post_details_likes.text = likesCount.toString()

            imageAdapter.updateData(model.images)
        }
    }

    private fun preparePostText(text: String): Spanned {
        val preparedText = text.replace("\n", "<br>")

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            Html.fromHtml(preparedText, Html.FROM_HTML_MODE_LEGACY)
        else
            Html.fromHtml(preparedText)
    }
}
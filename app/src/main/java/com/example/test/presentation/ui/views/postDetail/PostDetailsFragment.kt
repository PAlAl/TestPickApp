package com.example.test.presentation.ui.views.postDetail

import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.test.R
import com.example.test.presentation.mvp.global.ImageLoader
import com.example.test.presentation.mvp.presenters.postDetail.IPostDetailsView
import com.example.test.presentation.mvp.presenters.postDetail.PostDetailsPresenter
import com.example.test.presentation.ui.views.global.AppToolbarFragment
import com.example.test.presentation.ui.views.postDetail.models.PostDetailsViewModel
import kotlinx.android.synthetic.main.fragment_post_details.*
import kotlinx.android.synthetic.main.item_post_details_image.view.*
import moxy.presenter.InjectPresenter

class PostDetailsFragment : AppToolbarFragment(), IPostDetailsView {
    override val layoutRes: Int = R.layout.fragment_post_details
    override val appToolbarTitleId: Int = R.string.post_detail_app_bar_title
    override val isAppToolbarHomeAsUpEnabled: Boolean = true

    @InjectPresenter
    lateinit var presenter: PostDetailsPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setHasOptionsMenu(true)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postId: Int = arguments?.let {
            PostDetailsFragmentArgs.fromBundle(it).postId
        } ?: 0

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
            post_details_text.text = text
            post_details_date.text = dateString
            post_details_likes.text = likesCount.toString()
            renderImages(model.images)
        }
    }

    private fun renderImages(urls: List<String>) {
        with(post_details_images_container) {
            removeAllViews()
            visibility = if (urls.isEmpty()) View.GONE else View.VISIBLE

            urls.forEach {
                val view = layoutInflater.inflate(R.layout.item_post_details_image, this, false)
                addView(view)
                ImageLoader.simpleLoad(this, it, view.post_details_image)
            }
        }
    }
}
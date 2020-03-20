package com.example.test.presentation.mvp.presenters.postDetail

import android.util.Log
import com.example.test.TestPikabuApplication
import com.example.test.domain.interactors.posts.IPostsInteractor
import com.example.test.presentation.mvp.global.BasePresenter
import com.example.test.presentation.mvp.global.DateFormats
import com.example.test.presentation.ui.views.postDetail.models.PostDetailsViewModel
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class PostDetailsPresenter : BasePresenter<IPostDetailsView>() {

    @Inject
    lateinit var interactor: IPostsInteractor

    init {
        TestPikabuApplication.instance.getAppComponent().inject(this)
    }

    private fun loadPostDetailsById(postId: Int) {
        interactor.getPostDetails(postId)
                .doOnSubscribe {
                    viewState.showBlockingProgress(true)
                }
                .doAfterTerminate {
                    viewState.showBlockingProgress(false)
                }
                .subscribeDispose({
                    viewState.setData(
                            if (it.isEmpty)
                                null
                            else
                                PostDetailsViewModel(it.id, it.date.toString(DateFormats.longDateTimeFormat), it.title, it.text, it.images, it.likesCount)
                    )
                }, {
                    viewState.setData(null)
                    Log.e("Error", "in PostDetailPresenter at getPostDetails ${it.message}")
                })

    }

    fun onViewCreated(postId: Int) {
        loadPostDetailsById(postId)
    }
}
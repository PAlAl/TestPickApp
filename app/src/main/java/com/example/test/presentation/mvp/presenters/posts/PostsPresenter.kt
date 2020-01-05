package com.example.test.presentation.mvp.presenters.posts

import android.util.Log
import com.example.test.TestPikabuApplication
import com.example.test.domain.interactors.posts.PostsInteractor
import com.example.test.presentation.mvp.global.BasePresenter
import com.example.test.presentation.mvp.global.DateFormats
import com.example.test.presentation.ui.views.posts.models.PostViewModel
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class PostsPresenter : BasePresenter<IPostsView>() {

    @Inject
    lateinit var interactor: PostsInteractor

    init {
        TestPikabuApplication.instance.getAppComponent().inject(this)
        loadPosts()
    }

    private fun loadPosts() {
        interactor.getPosts()
                .doOnSubscribe {
                    viewState.showBlockingProgress(true)
                }
                .doAfterTerminate {
                    viewState.showBlockingProgress(false)
                }
                .subscribeDispose({
                    viewState.setPosts(it.map { PostViewModel(it.id, it.date.toString(DateFormats.longDateTimeFormat), it.title, it.previewText, it.likesCount) })
                }, {
                    Log.e("Error", "in PostsPresenter at getPosts ${it.message}")
                })
    }

    val onItemClick: (postId: Int) -> Unit = {

    }
}
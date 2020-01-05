package com.example.test.presentation.mvp.presenters.posts

import android.util.Log
import com.example.test.TestPikabuApplication
import com.example.test.domain.interactors.posts.PostsInteractor
import com.example.test.presentation.mvp.global.BasePresenter
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class PostsPresenter : BasePresenter<IPostsView>() {

    @Inject
    lateinit var interactor: PostsInteractor

    init {
        TestPikabuApplication.instance.getAppComponent().inject(this)
    }

    fun onCl() {
        interactor.getPosts()
                .doOnSubscribe {
                    viewState.showBlockingProgress(true)
                }
                .doAfterTerminate {
                    viewState.showBlockingProgress(false)
                }
                .subscribeDispose({
                    val list = it
                }, {
                    Log.e("Error", "in PostsPresenter at getPosts ${it.message}")
                })
    }
}
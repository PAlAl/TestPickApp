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

    private val postsModels: ArrayList<PostViewModel> = arrayListOf()

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
                    postsModels.clear()
                    postsModels.addAll(it.mapIndexed { index, post ->
                        PostViewModel(post.id, post.date, post.date.toString(DateFormats.longDateTimeFormat),
                                post.title, post.previewText, post.likesCount, index)
                    })
                    render()
                }, {
                    Log.e("Error", "in PostsPresenter at getPosts ${it.message}")
                })
    }

    private fun render() {
        viewState.setPosts(postsModels)
    }

    fun onSortByRankClick() {
        postsModels.sortByDescending { it.likesCount }
        render()
    }

    fun onSortByDateClick() {
        postsModels.sortByDescending { it.date }
        render()
    }

    fun onSortClearClick() {
        postsModels.sortBy { it.defaultPosition }
        render()
    }

    val onItemClick: (Int) -> Unit = {

    }

    val onExpandCollapseItemClick: (Int) -> Unit = { postId ->
        postsModels.firstOrNull { it.id == postId }?.let {
            it.isExpandText = !it.isExpandText
            render()
        }
    }
}
package com.example.test.presentation.mvp.presenters.posts

import com.example.test.presentation.ui.views.posts.models.PostViewModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface IPostsView : MvpView {
    fun showBlockingProgress(isShow: Boolean)
    fun setPosts(posts: List<PostViewModel>)
}
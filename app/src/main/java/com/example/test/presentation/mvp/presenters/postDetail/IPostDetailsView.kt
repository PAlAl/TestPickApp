package com.example.test.presentation.mvp.presenters.postDetail

import com.example.test.presentation.ui.views.postDetail.models.PostDetailsViewModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface IPostDetailsView : MvpView {
    fun showBlockingProgress(isShow: Boolean)
    fun setData(model: PostDetailsViewModel?)
}
package com.example.test.presentation.mvp.global

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import moxy.MvpPresenter
import moxy.MvpView

abstract class BasePresenter<T : MvpView> : MvpPresenter<T>() {
    protected var disposables = CompositeDisposable()

    protected fun <T : Any> Single<T>.subscribeDispose(block: (t: T) -> Unit, errorBlock: (t: Throwable) -> Unit = {}) {
        disposables.add(
                this.subscribe({ block(it) }, { errorBlock(it) })
        )
    }

    override fun onDestroy() {
        disposables.dispose()
    }
}
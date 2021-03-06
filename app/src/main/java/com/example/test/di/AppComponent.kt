package com.example.test.di

import com.example.test.presentation.mvp.presenters.postDetail.PostDetailsPresenter
import com.example.test.presentation.mvp.presenters.posts.PostsPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, AppModule::class, NetCoreModule::class, RepositoriesModule::class, InteractorsModule::class])
interface AppComponent {
    fun inject(presenter: PostsPresenter)
    fun inject(presenter: PostDetailsPresenter)
}
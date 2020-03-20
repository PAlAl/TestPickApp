package com.example.test.di

import com.example.test.domain.interactors.posts.IPostsInteractor
import com.example.test.domain.interactors.posts.PostsInteractor
import dagger.Binds
import dagger.Module

@Module
interface InteractorsModule {
    @Binds
    fun providePostsInteractor(interactor: PostsInteractor): IPostsInteractor
}
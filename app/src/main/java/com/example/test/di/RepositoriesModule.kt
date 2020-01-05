package com.example.test.di

import com.example.test.data.repositories.posts.PostsRepository
import com.example.test.domain.global.repositories.IPostsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoriesModule {
    @Binds
    abstract fun providePostsRepository(repository: PostsRepository): IPostsRepository
}
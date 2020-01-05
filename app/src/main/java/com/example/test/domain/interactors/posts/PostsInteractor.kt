package com.example.test.domain.interactors.posts

import com.example.test.domain.global.models.Post
import com.example.test.domain.global.repositories.IPostsRepository
import io.reactivex.Single
import javax.inject.Inject

class PostsInteractor @Inject constructor(private val repository: IPostsRepository) {

    fun getPosts(): Single<List<Post>> {
        return repository.getPosts()
    }
}
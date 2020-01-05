package com.example.test.domain.global.repositories

import com.example.test.domain.global.models.Post
import io.reactivex.Single

interface IPostsRepository {
    fun getPosts(): Single<List<Post>>
}
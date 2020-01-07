package com.example.test.domain.global.repositories

import com.example.test.domain.global.models.posts.Post
import com.example.test.domain.global.models.posts.PostDetails
import io.reactivex.Single

interface IPostsRepository {
    fun getPosts(): Single<List<Post>>
    fun getPostDetails(postId: Int): Single<PostDetails>
}
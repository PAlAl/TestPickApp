package com.example.test.domain.interactors.posts

import com.example.test.domain.global.models.posts.Post
import com.example.test.domain.global.models.posts.PostDetails
import com.example.test.domain.global.repositories.IPostsRepository
import io.reactivex.Single
import javax.inject.Inject

class PostsInteractor @Inject constructor(private val repository: IPostsRepository) : IPostsInteractor {
    override fun getPosts(): Single<List<Post>> {
        return repository.getPosts()
    }

    override fun getPostDetails(postId: Int): Single<PostDetails> {
        return repository.getPostDetails(postId)
    }
}
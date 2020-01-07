package com.example.test.data.repositories.posts

import com.example.test.data.models.posts.mappers.PostsMapper
import com.example.test.data.network.IApiService
import com.example.test.domain.global.managers.ISchedulersManager
import com.example.test.domain.global.models.posts.Post
import com.example.test.domain.global.models.posts.PostDetails
import com.example.test.domain.global.repositories.IPostsRepository
import io.reactivex.Single
import javax.inject.Inject

class PostsRepository @Inject constructor(private val api: IApiService, private val schedulers: ISchedulersManager) : IPostsRepository {

    override fun getPosts(): Single<List<Post>> {
        return api.getPosts()
                .map {
                    PostsMapper.fromResponse(it)
                }
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
    }

    override fun getPostDetails(postId: Int): Single<PostDetails> {
        return api.getPostDetails(postId)
                .map {
                    val postDetail = PostsMapper.fromResponseDetails(it)
                    postDetail ?: PostDetails.empty
                }
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
    }
}
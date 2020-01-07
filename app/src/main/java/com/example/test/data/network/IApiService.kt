package com.example.test.data.network

import com.example.test.data.models.posts.response.GetPostDetailsResponse
import com.example.test.data.models.posts.response.GetPostsListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IApiService {

    @GET("files/api201910/posts.json ")
    fun getPosts(): Single<GetPostsListResponse>

    @GET("files/api201910/{postId}.json ")
    fun getPostDetails(@Path(value = "postId", encoded = true) postId: Int): Single<GetPostDetailsResponse>
}
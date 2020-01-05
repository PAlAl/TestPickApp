package com.example.test.data.network

import com.example.test.data.models.posts.response.GetPostsListResponse
import io.reactivex.Single
import retrofit2.http.GET

interface IApiService {

    @GET("files/api201910/posts.json ")
    fun getPosts(): Single<GetPostsListResponse>
}
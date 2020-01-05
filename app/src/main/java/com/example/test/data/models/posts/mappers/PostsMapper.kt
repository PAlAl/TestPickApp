package com.example.test.data.models.posts.mappers

import com.example.test.data.models.posts.response.GetPostsListResponse
import com.example.test.domain.global.models.Post
import org.joda.time.DateTime

object PostsMapper {
    fun fromResponse(response: GetPostsListResponse): List<Post> {
        return response.posts?.map {
            Post(it.postId, DateTime(it.timeshamp), it.title ?: "",
                    it.preview_text ?: "", it.likes_count ?: 0)
        } ?: listOf()
    }
}
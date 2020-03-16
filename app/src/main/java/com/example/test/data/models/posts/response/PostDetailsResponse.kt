package com.example.test.data.models.posts.response

import org.joda.time.DateTime

class PostDetailsResponse(val postId: Int, val timeshamp: DateTime, val title: String?, val text: String?, val images: List<String>?, val likes_count: Int?) {
}
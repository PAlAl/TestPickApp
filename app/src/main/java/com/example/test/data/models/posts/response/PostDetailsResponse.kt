package com.example.test.data.models.posts.response

class PostDetailsResponse(val postId: Int, val timeshamp: Long, val title: String?, val text: String?, val images: List<String>?, val likes_count: Int?) {
}
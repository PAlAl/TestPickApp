package com.example.test.data.models.posts.response

import org.joda.time.DateTime

class PostResponse(val postId: Int, val timeshamp: DateTime, val title: String?, val preview_text: String?, val likes_count: Int?) {
}
package com.example.test.data.models.posts.response

import com.google.gson.annotations.SerializedName
import org.joda.time.DateTime

class PostResponse(
        @SerializedName("postId")
        val postId: Int,
        @SerializedName("timeshamp")
        val timeshamp: DateTime,
        @SerializedName("title")
        val title: String?,
        @SerializedName("preview_text")
        val preview_text: String?,
        @SerializedName("likes_count")
        val likes_count: Int?) {
}
package com.example.test.data.models.posts.response

import com.google.gson.annotations.SerializedName
import org.joda.time.DateTime

class PostDetailsResponse(
        @SerializedName("postId")
        val postId: Int,
        @SerializedName("timeshamp")
        val timeshamp: DateTime,
        @SerializedName("title")
        val title: String?,
        @SerializedName("text")
        val text: String?,
        @SerializedName("images")
        val images: List<String>?,
        @SerializedName("likes_count")
        val likes_count: Int?) {
}
package com.example.test.data.models.posts.response

import com.google.gson.annotations.SerializedName

class GetPostsListResponse(@SerializedName("posts") val posts: List<PostResponse>?) {
}
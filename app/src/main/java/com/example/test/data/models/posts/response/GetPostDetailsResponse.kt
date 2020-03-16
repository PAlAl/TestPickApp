package com.example.test.data.models.posts.response

import com.google.gson.annotations.SerializedName

class GetPostDetailsResponse(@SerializedName("post") val post: PostDetailsResponse?) {
}
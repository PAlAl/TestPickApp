package com.example.test.domain.global.models.posts

import org.joda.time.DateTime

data class PostDetails(val id: Int, val date: DateTime, val title: String, val text: String, val images: List<String>, val likesCount: Int, val isEmpty: Boolean = false) {

    companion object {
        val empty = PostDetails(0, DateTime.now(), "", "", listOf(), 0, true)
    }
}
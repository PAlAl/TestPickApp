package com.example.test.domain.global.models.posts

import org.joda.time.DateTime

data class Post(val id: Int, val date: DateTime, val title: String, val previewText: String, val likesCount: Int) {
}
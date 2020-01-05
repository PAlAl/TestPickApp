package com.example.test.presentation.ui.views.posts.models

import org.joda.time.DateTime

class PostViewModel(val id: Int, val date: DateTime, val title: String, val text: String, val likesCount: Int, val defaultPosition: Int) {
}
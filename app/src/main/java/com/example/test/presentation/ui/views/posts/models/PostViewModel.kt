package com.example.test.presentation.ui.views.posts.models

import org.joda.time.DateTime

data class PostViewModel(val id: Int, val date: DateTime, val dateString: String, val title: String, val text: String, val likesCount: Int, val defaultPosition: Int, var isExpandText: Boolean = false) {
}
package com.example.test.presentation.ui.views.postDetail.models

data class PostDetailsViewModel(val id: Int, val dateString: String, val title: String, val text: String, val images: List<String>, val likesCount: Int) {
}
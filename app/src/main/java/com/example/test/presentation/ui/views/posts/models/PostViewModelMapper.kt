package com.example.test.presentation.ui.views.posts.models

import com.example.test.domain.global.models.posts.Post
import com.example.test.presentation.mvp.global.DateFormats

object PostViewModelMapper {
    fun toViewModel(post: Post, defaultPosition: Int): PostViewModel {
        return PostViewModel(post.id, post.date, post.date.toString(DateFormats.longDateTimeFormat),
                post.title, post.previewText, post.likesCount, defaultPosition)
    }
}
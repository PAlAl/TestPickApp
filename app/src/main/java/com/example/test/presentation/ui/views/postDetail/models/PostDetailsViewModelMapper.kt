package com.example.test.presentation.ui.views.postDetail.models

import com.example.test.domain.global.models.posts.PostDetails
import com.example.test.presentation.mvp.global.DateFormats

object PostDetailsViewModelMapper {
    fun toViewModel(post: PostDetails): PostDetailsViewModel {
        return PostDetailsViewModel(post.id, post.date.toString(DateFormats.longDateTimeFormat), post.title, post.text, post.images, post.likesCount)
    }
}
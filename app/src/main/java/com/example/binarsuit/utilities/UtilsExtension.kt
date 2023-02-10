package com.example.binarsuit.utilities

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.loadImageUrl(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}
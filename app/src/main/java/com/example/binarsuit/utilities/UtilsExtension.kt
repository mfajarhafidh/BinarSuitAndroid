package com.example.binarsuit.utilities

import android.content.Context
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.loadImageUrl(url: String) {
    Glide.with(context)
        .load(url)
        .into(this)
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
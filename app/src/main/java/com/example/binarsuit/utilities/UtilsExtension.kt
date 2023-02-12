package com.example.binarsuit.utilities

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

fun AppCompatImageView.loadImageUrl(url: String) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .into(this)
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.intentTo(clazz: Class<*>, beforeStart: (Intent) -> Unit) {
    val intent = Intent(this, clazz)
    beforeStart.invoke(intent)
    startActivity(intent)
}
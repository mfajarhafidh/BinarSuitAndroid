package com.example.binarsuit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.binarsuit.databinding.ActivityPvpBinding

class PvpActivity : AppCompatActivity() {

    private val binding: ActivityPvpBinding by lazy {
        ActivityPvpBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



    }
}
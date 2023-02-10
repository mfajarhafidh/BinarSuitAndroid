package com.example.binarsuit.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.binarsuit.databinding.ActivitySplashScreenBinding
import com.example.binarsuit.utilities.loadImageUrl

class SplashScreen : AppCompatActivity() {

    private val binding: ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imgSplashScreenTop.loadImageUrl(IMG_URL)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    companion object {
        private const val IMG_URL =
            "https://i.ibb.co/HC5ZPgD/splash-screen1.png"
    }
}
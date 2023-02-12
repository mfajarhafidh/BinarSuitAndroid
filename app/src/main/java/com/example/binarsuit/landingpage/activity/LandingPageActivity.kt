package com.example.binarsuit.landingpage.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.binarsuit.landingpage.adapter.ViewPagerAdapter
import com.example.binarsuit.databinding.ActivityLandingPageBinding

class LandingPageActivity : AppCompatActivity() {

    private val binding: ActivityLandingPageBinding by lazy {
        ActivityLandingPageBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupViewPager()
    }

    private fun setupViewPager() {
        val viewPager = binding.viewPager
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)
        binding.dotsIndicator.attachTo(viewPager)
    }
}
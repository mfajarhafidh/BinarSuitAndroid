package com.example.binarsuit.landingpage.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.binarsuit.landingpage.fragments.FirstLandingPageFragment
import com.example.binarsuit.landingpage.fragments.SecondLandingPageFragment
import com.example.binarsuit.landingpage.fragments.ThirdLandingPageFragment

@Suppress("DEPRECATION")
class ViewPagerAdapter(
    fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val count = 3

    override fun getCount(): Int {
        return count
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FirstLandingPageFragment()
            1 -> SecondLandingPageFragment()
            else -> ThirdLandingPageFragment()
        }
    }
}
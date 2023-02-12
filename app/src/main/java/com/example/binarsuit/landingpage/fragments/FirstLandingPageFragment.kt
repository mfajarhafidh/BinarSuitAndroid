package com.example.binarsuit.landingpage.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.binarsuit.databinding.FragmentLandingPageFirstBinding

class FirstLandingPageFragment : Fragment() {

    private var _binding: FragmentLandingPageFirstBinding? = null
    private val binding: FragmentLandingPageFirstBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandingPageFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
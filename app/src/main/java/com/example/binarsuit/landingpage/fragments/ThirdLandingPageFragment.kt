package com.example.binarsuit.landingpage.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.binarsuit.databinding.FragmentLandingPageThirdBinding
import com.example.binarsuit.mainmenu.MainMenuActivity
import com.example.binarsuit.utilities.intentTo

class ThirdLandingPageFragment : Fragment() {

    private var _binding: FragmentLandingPageThirdBinding? = null
    private val binding: FragmentLandingPageThirdBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLandingPageThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.etUsername.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if (s.isEmpty()) {
                    binding.imgNext.isEnabled = false
                    binding.imgNext.isVisible = false
                } else {
                    binding.imgNext.isEnabled = true
                    binding.imgNext.isVisible = true
                    binding.imgNext.setOnClickListener {
                        startLogin()
                    }
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun startLogin() {
        val username = binding.etUsername.text.toString()
        context?.intentTo(MainMenuActivity::class.java) { intent ->
            intent.putExtra("username", username)
        }
    }
}
package com.example.binarsuit.mainmenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.binarsuit.game.PvcActivity
import com.example.binarsuit.game.PvpActivity
import com.example.binarsuit.R
import com.example.binarsuit.databinding.ActivityMenuMainBinding
import com.example.binarsuit.utilities.intentTo
import com.google.android.material.snackbar.Snackbar

class MainMenuActivity : AppCompatActivity() {

    private val binding: ActivityMenuMainBinding by lazy {
        ActivityMenuMainBinding.inflate(layoutInflater)
    }

    private val username: String by lazy {
        intent.getStringExtra("username") ?: "unknown"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (username != null) {
            val snackbar =
                Snackbar.make(binding.root, "Selamat Datang $username", Snackbar.LENGTH_SHORT)
            snackbar.setAction(R.string.close) {
                snackbar.dismiss()
            }
            snackbar.show()
        }

        binding.tvPvp.text = "$username vs Pemain"
        binding.tvPvc.text = "$username vs CPU"

        binding.imgPvc.setOnClickListener {
            startPvcActivity()
        }

        binding.imgPvp.setOnClickListener {
            startPvpActivity()
        }


    }

    private fun startPvcActivity() {
        intentTo(PvcActivity::class.java) {
                intent -> intent.putExtra("username", username)
        }
    }

    private fun startPvpActivity() {
        intentTo(PvpActivity::class.java) {
                intent -> intent.putExtra("username", username)
        }
    }
}
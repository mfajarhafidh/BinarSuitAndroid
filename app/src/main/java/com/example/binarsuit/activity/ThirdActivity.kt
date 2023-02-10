package com.example.binarsuit.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.binarsuit.MainActivity
import com.example.binarsuit.PvpActivity
import com.example.binarsuit.R
import com.example.binarsuit.databinding.ActivityThirdBinding
import com.google.android.material.snackbar.Snackbar

class ThirdActivity : AppCompatActivity() {

    private val binding: ActivityThirdBinding by lazy {
        ActivityThirdBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val username = intent.getStringExtra("username")

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
            startMainActivity()
        }

        binding.imgPvp.setOnClickListener {
            startPvpActivity()
        }


    }

    private fun startMainActivity() {
        val username = intent.getStringExtra("username")
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("username", username)
        startActivity(intent)
    }

    private fun startPvpActivity() {
        val username = intent.getStringExtra("username")
        val intent = Intent(this, PvpActivity::class.java)
        intent.putExtra("username", username)
        startActivity(intent)
    }
}
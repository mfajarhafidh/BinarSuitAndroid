package com.example.binarsuit

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.binarsuit.activity.ThirdActivity
import com.example.binarsuit.databinding.ActivityMainBinding
import com.example.binarsuit.utilities.showToast

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val username = intent.getStringExtra("username")

        binding.tvPvcPlayer.text = "$username"

        //Rock ImageView
        binding.imgPvcPlayerRock.setOnClickListener {
            binding.imgPvcPlayerRock.setBackgroundColor(Color.CYAN)
            Log.i("Main Activity", "$username choose ROCK")
            showToast("$username Memilih Batu")

            when ((1..3).random()) {
                1 -> {
                    binding.imgPvcComRock.setBackgroundColor(Color.CYAN)

                    textDraw()

                    Log.i("Main Activity", "Player: ROCK")
                    Log.i("Main Activity", "Computer: ROCK")
                    Log.i("Main Activity", "Result: DRAW")
                    showToast("CPU Memilih Batu")
                }
                2 -> {
                    binding.imgPvcComPaper.setBackgroundColor(Color.CYAN)

                    textComWin()

                    Log.i("Main Activity", "Player: ROCK")
                    Log.i("Main Activity", "Computer: PAPER")
                    Log.i("Main Activity", "Result: COMPUTER WIN")
                    showToast("CPU Memilih Kertas")
                }
                else -> {
                    binding.imgPvcComScissor.setBackgroundColor(Color.CYAN)

                    textPlayerWin()

                    Log.i("Main Activity", "Player: ROCK")
                    Log.i("Main Activity", "Computer: SCISSOR")
                    Log.i("Main Activity", "Result: PLAYER WIN")
                    showToast("CPU Memilih Gunting")
                }
            }
            notClickableBtn()
        }

        //Paper ImageView
        binding.imgPvcPlayerPaper.setOnClickListener {
            binding.imgPvcPlayerPaper.setBackgroundColor(Color.CYAN)
            Log.i("Main Activity", "$username choose PAPER")
            showToast("$username Memilih Kertas")

            when ((1..3).random()) {
                1 -> {
                    binding.imgPvcComRock.setBackgroundColor(Color.CYAN)

                    textPlayerWin()

                    Log.i("Main Activity", "Player: PAPER")
                    Log.i("Main Activity", "Computer: ROCK")
                    Log.i("Main Activity", "Result: PLAYER WIN")
                    showToast("CPU Memilih Batu")
                }
                2 -> {
                    binding.imgPvcComPaper.setBackgroundColor(Color.CYAN)

                    textDraw()

                    Log.i("Main Activity", "Player: PAPER")
                    Log.i("Main Activity", "Computer: PAPER")
                    Log.i("Main Activity", "Result: DRAW")
                    showToast("CPU Memilih Kertas")
                }
                else -> {
                    binding.imgPvcComScissor.setBackgroundColor(Color.CYAN)

                    textComWin()

                    Log.i("Main Activity", "Player: PAPER")
                    Log.i("Main Activity", "Computer: SCISSOR")
                    Log.i("Main Activity", "Result: COMPUTER WIN")
                    showToast("CPU Memilih Gunting")
                }
            }
            notClickableBtn()
        }

        //Scissor ImageView
        binding.imgPvcPlayerScissor.setOnClickListener {
            binding.imgPvcPlayerScissor.setBackgroundColor(Color.CYAN)
            Log.i("Main Activity", "$username choose SCISSOR")
            showToast("$username Memilih Gunting")

            when ((1..3).random()) {
                1 -> {
                    binding.imgPvcComRock.setBackgroundColor(Color.CYAN)

                    textComWin()

                    Log.i("Main Activity", "Player: SCISSOR")
                    Log.i("Main Activity", "Computer: ROCK")
                    Log.i("Main Activity", "Result: COMPUTER WIN")
                    showToast("CPU Memilih Batu")
                }
                2 -> {
                    binding.imgPvcComPaper.setBackgroundColor(Color.CYAN)

                    textPlayerWin()

                    Log.i("Main Activity", "Player: SCISSOR")
                    Log.i("Main Activity", "Computer: PAPER")
                    Log.i("Main Activity", "Result: PLAYER WIN")
                    showToast("CPU Memilih Kertas")
                }
                else -> {
                    binding.imgPvcComScissor.setBackgroundColor(Color.CYAN)

                    textDraw()

                    Log.i("Main Activity", "Player: SCISSOR")
                    Log.i("Main Activity", "Computer: SCISSOR")
                    Log.i("Main Activity", "Result: DRAW")
                    showToast("CPU Memilih Gunting")
                }
            }
            notClickableBtn()
        }

        //Restart ImageView
        restartApp()

        //Closing Main Activity to Third Activity (Main Menu)
        binding.imgPvcClose.setOnClickListener {
            closeActivity()
        }

    }

    //Restart function, finish the activity and startActivity again
    private fun restartApp() {
        binding.imgPvcRestart.setOnClickListener {
            finish()
            startActivity(intent)
        }
    }

    private fun notClickableBtn() {
        binding.imgPvcPlayerRock.isClickable = false
        binding.imgPvcPlayerPaper.isClickable = false
        binding.imgPvcPlayerScissor.isClickable = false
    }

    private fun textPlayerWin() {
        binding.tvPvcVs.text = "Player WIN"
        binding.tvPvcVs.textSize = 20.0f
        binding.tvPvcVs.setBackgroundColor(Color.GREEN)
        binding.tvPvcVs.setTextColor(Color.WHITE)
    }

    private fun textComWin() {
        binding.tvPvcVs.text = "Computer WIN"
        binding.tvPvcVs.textSize = 20.0f
        binding.tvPvcVs.setBackgroundColor(Color.GREEN)
        binding.tvPvcVs.setTextColor(Color.WHITE)
    }

    private fun textDraw() {
        binding.tvPvcVs.text = "DRAW"
        binding.tvPvcVs.textSize = 20.0f
        binding.tvPvcVs.setBackgroundColor(Color.GREEN)
        binding.tvPvcVs.setTextColor(Color.WHITE)
    }

    private fun closeActivity() {
        val username = intent.getStringExtra("username")
        val intent = Intent(this, ThirdActivity::class.java)
        intent.putExtra("username", username)
        startActivity(intent)
    }
}
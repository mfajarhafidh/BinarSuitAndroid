package com.example.binarsuit.game

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.binarsuit.R
import com.example.binarsuit.databinding.ActivityPvcBinding
import com.example.binarsuit.databinding.LayoutDialogBinding
import com.example.binarsuit.mainmenu.MainMenuActivity
import com.example.binarsuit.utilities.intentTo
import com.example.binarsuit.utilities.showToast

class PvcActivity : AppCompatActivity() {

    private val binding: ActivityPvcBinding by lazy {
        ActivityPvcBinding.inflate(layoutInflater)
    }

    private val username: String by lazy {
        intent.getStringExtra("username") ?: "unknown"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvPvcPlayer.text = username

        //Rock ImageView
        binding.imgPvcPlayerRock.setOnClickListener {
            binding.imgPvcPlayerRock.setBackgroundColor(Color.CYAN)
            Log.i("Main Activity", "$username choose ROCK")
            showToast("$username Memilih Batu")

            when ((1..3).random()) {
                1 -> {
                    binding.imgPvcComRock.setBackgroundColor(Color.CYAN)

                    Log.i("Main Activity", "Player: ROCK")
                    Log.i("Main Activity", "Computer: ROCK")
                    Log.i("Main Activity", "Result: DRAW")
                    showToast("CPU Memilih Batu")

                    customDialog("SERI!")
                }
                2 -> {
                    binding.imgPvcComPaper.setBackgroundColor(Color.CYAN)

                    Log.i("Main Activity", "Player: ROCK")
                    Log.i("Main Activity", "Computer: PAPER")
                    Log.i("Main Activity", "Result: COMPUTER WIN")
                    showToast("CPU Memilih Kertas")

                    customDialog("CPU MENANG!")
                }
                else -> {
                    binding.imgPvcComScissor.setBackgroundColor(Color.CYAN)

                    Log.i("Main Activity", "Player: ROCK")
                    Log.i("Main Activity", "Computer: SCISSOR")
                    Log.i("Main Activity", "Result: $username WIN")
                    showToast("CPU Memilih Gunting")

                    customDialog("$username MENANG!")
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

                    Log.i("Main Activity", "Player: PAPER")
                    Log.i("Main Activity", "Computer: ROCK")
                    Log.i("Main Activity", "Result: $username WIN")
                    showToast("CPU Memilih Batu")

                    customDialog("$username MENANG!")
                }
                2 -> {
                    binding.imgPvcComPaper.setBackgroundColor(Color.CYAN)

                    Log.i("Main Activity", "Player: PAPER")
                    Log.i("Main Activity", "Computer: PAPER")
                    Log.i("Main Activity", "Result: DRAW")
                    showToast("CPU Memilih Kertas")

                    customDialog("SERI!")
                }
                else -> {
                    binding.imgPvcComScissor.setBackgroundColor(Color.CYAN)

                    Log.i("Main Activity", "Player: PAPER")
                    Log.i("Main Activity", "Computer: SCISSOR")
                    Log.i("Main Activity", "Result: COMPUTER WIN")
                    showToast("CPU Memilih Gunting")

                    customDialog("CPU MENANG!")
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

                    Log.i("Main Activity", "Player: SCISSOR")
                    Log.i("Main Activity", "Computer: ROCK")
                    Log.i("Main Activity", "Result: COMPUTER WIN")
                    showToast("CPU Memilih Batu")

                    customDialog("CPU MENANG!")
                }
                2 -> {
                    binding.imgPvcComPaper.setBackgroundColor(Color.CYAN)

                    Log.i("Main Activity", "Player: SCISSOR")
                    Log.i("Main Activity", "Computer: PAPER")
                    Log.i("Main Activity", "Result: $username WIN")
                    showToast("CPU Memilih Kertas")

                    customDialog("$username MENANG!")
                }
                else -> {
                    binding.imgPvcComScissor.setBackgroundColor(Color.CYAN)

                    Log.i("Main Activity", "Player: SCISSOR")
                    Log.i("Main Activity", "Computer: SCISSOR")
                    Log.i("Main Activity", "Result: DRAW")
                    showToast("CPU Memilih Gunting")

                    customDialog("SERI!")
                }
            }
            notClickableBtn()
        }

        //Restart Activity
        binding.imgPvcRestart.setOnClickListener {
            restartMainActivity()
        }

        //Closing PvcActivity to MainMenuActivity
        binding.imgPvcClose.setOnClickListener {
            closeActivity()
        }

    }

    //Restart function, restart PvcActivity
    private fun restartMainActivity() {
        intentTo(PvcActivity::class.java) { intent ->
            intent.putExtra("username", username)
        }
    }

    private fun notClickableBtn() {
        binding.imgPvcPlayerRock.isClickable = false
        binding.imgPvcPlayerPaper.isClickable = false
        binding.imgPvcPlayerScissor.isClickable = false
    }

    private fun closeActivity() {
        intentTo(MainMenuActivity::class.java) { intent ->
            intent.putExtra("username", username)
        }
    }

    private fun customDialog(message: String) {
        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setCancelable(false)

        val view = LayoutInflater.from(this).inflate(R.layout.layout_dialog, null, false)
        val dialogBinding = LayoutDialogBinding.bind(view)
        dialogBuilder.setView(view)

        val dialog = dialogBuilder.create()

        dialogBinding.tvResult.text = message

        dialogBinding.btnRestart.setOnClickListener {
            restartMainActivity()
        }

        dialogBinding.btnMenu.setOnClickListener {
            closeActivity()
        }

        dialog.show()
    }
}
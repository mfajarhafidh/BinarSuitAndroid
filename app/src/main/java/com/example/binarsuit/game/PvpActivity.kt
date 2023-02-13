package com.example.binarsuit.game

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.binarsuit.R
import com.example.binarsuit.databinding.ActivityPvpBinding
import com.example.binarsuit.databinding.LayoutDialogBinding
import com.example.binarsuit.mainmenu.MainMenuActivity
import com.example.binarsuit.utilities.intentTo
import com.example.binarsuit.utilities.showToast

class PvpActivity : AppCompatActivity() {

    private val binding: ActivityPvpBinding by lazy {
        ActivityPvpBinding.inflate(layoutInflater)
    }

    private val username: String by lazy {
        intent.getStringExtra("username") ?: "unknown"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.tvPvpPlayer.text = username

        //Rock ImageView
        binding.imgPvpPlayerRock.setOnClickListener {
            binding.imgPvpPlayerRock.setBackgroundColor(Color.CYAN)
            Log.i("Main Activity", "$username choose ROCK")
            showToast("$username Memilih Batu")

            binding.imgPvpPlayer2Rock.setOnClickListener {
                binding.imgPvpPlayer2Rock.setBackgroundColor(Color.CYAN)

                Log.i("Main Activity", "$username: ROCK")
                Log.i("Main Activity", "Pemain 2: ROCK")
                Log.i("Main Activity", "Result: DRAW")
                showToast("Pemain 2 Memilih Batu")

                customDialog("SERI!")

                notClickableBtnPlayerTwo()
            }

            binding.imgPvpPlayer2Paper.setOnClickListener {
                binding.imgPvpPlayer2Paper.setBackgroundColor(Color.CYAN)

                Log.i("Main Activity", "$username: ROCK")
                Log.i("Main Activity", "Pemain 2: PAPER")
                Log.i("Main Activity", "Result: Pemain 2 WIN")
                showToast("Pemain 2 Memilih Kertas")

                customDialog("PEMAIN 2 MENANG!")

                notClickableBtnPlayerTwo()
            }

            binding.imgPvpPlayer2Scissor.setOnClickListener {
                binding.imgPvpPlayer2Scissor.setBackgroundColor(Color.CYAN)

                Log.i("Main Activity", "$username: ROCK")
                Log.i("Main Activity", "Pemain 2: SCISSOR")
                Log.i("Main Activity", "Result: $username WIN")
                showToast("Pemain 2 Memilih Gunting")

                customDialog("$username MENANG!")

                notClickableBtnPlayerTwo()
            }

            notClickableBtnPlayer()
        }

        //Paper ImageView
        binding.imgPvpPlayerPaper.setOnClickListener {
            binding.imgPvpPlayerPaper.setBackgroundColor(Color.CYAN)
            Log.i("Main Activity", "$username choose PAPER")
            showToast("$username Memilih Kertas")

            binding.imgPvpPlayer2Rock.setOnClickListener {
                binding.imgPvpPlayer2Rock.setBackgroundColor(Color.CYAN)

                Log.i("Main Activity", "$username: PAPER")
                Log.i("Main Activity", "Pemain 2: ROCK")
                Log.i("Main Activity", "Result: $username WIN!")
                showToast("Pemain 2 Memilih Batu")

                customDialog("$username MENANG!")
            }

            binding.imgPvpPlayer2Paper.setOnClickListener {
                binding.imgPvpPlayer2Paper.setBackgroundColor(Color.CYAN)

                Log.i("Main Activity", "$username: PAPER")
                Log.i("Main Activity", "Pemain 2: PAPER")
                Log.i("Main Activity", "Result: DRAW")
                showToast("Pemain 2 Memilih Kertas")

                customDialog("SERI!")
            }

            binding.imgPvpPlayer2Scissor.setOnClickListener {
                binding.imgPvpPlayer2Scissor.setBackgroundColor(Color.CYAN)

                Log.i("Main Activity", "$username: PAPER")
                Log.i("Main Activity", "Pemain 2: SCISSOR")
                Log.i("Main Activity", "Result: Pemain 2 WIN")
                showToast("Pemain 2 Memilih Gunting")

                customDialog("PEMAIN 2 MENANG!")
            }

            notClickableBtnPlayer()
        }

        //Scissor ImageView
        binding.imgPvpPlayerScissor.setOnClickListener {
            binding.imgPvpPlayerScissor.setBackgroundColor(Color.CYAN)
            Log.i("Main Activity", "$username choose SCISSOR")
            showToast("$username Memilih Gunting")

            binding.imgPvpPlayer2Rock.setOnClickListener {
                binding.imgPvpPlayer2Rock.setBackgroundColor(Color.CYAN)

                Log.i("Main Activity", "$username: SCISSOR")
                Log.i("Main Activity", "Pemain 2: ROCK")
                Log.i("Main Activity", "Result: Pemain 2 WIN!")
                showToast("Pemain 2 Memilih Batu")

                customDialog("PEMAIN 2 MENANG!")
            }

            binding.imgPvpPlayer2Paper.setOnClickListener {
                binding.imgPvpPlayer2Paper.setBackgroundColor(Color.CYAN)

                Log.i("Main Activity", "$username: SCISSOR")
                Log.i("Main Activity", "Pemain 2: PAPER")
                Log.i("Main Activity", "Result: $username WIN")
                showToast("Pemain 2 Memilih Kertas")

                customDialog("$username MENANG!")
            }

            binding.imgPvpPlayer2Scissor.setOnClickListener {
                binding.imgPvpPlayer2Scissor.setBackgroundColor(Color.CYAN)

                Log.i("Main Activity", "$username: SCISSOR")
                Log.i("Main Activity", "Pemain 2: SCISSOR")
                Log.i("Main Activity", "Result: DRAW")
                showToast("Pemain 2 Memilih Gunting")

                customDialog("SERI!")
            }

            notClickableBtnPlayer()
        }

        //Restart Activity
        binding.imgPvpRestart.setOnClickListener {
            restartMainActivity()
        }

        //Closing PvpActivity to MainMenuActivity
        binding.imgPvpClose.setOnClickListener {
            closeActivity()
        }
    }

    //Restart function, restart PvpActivity
    private fun restartMainActivity() {
        intentTo(PvpActivity::class.java) { intent ->
            intent.putExtra("username", username)
        }
    }

    private fun notClickableBtnPlayer() {
        binding.imgPvpPlayerRock.isClickable = false
        binding.imgPvpPlayerPaper.isClickable = false
        binding.imgPvpPlayerScissor.isClickable = false
    }

    private fun notClickableBtnPlayerTwo() {
        binding.imgPvpPlayer2Rock.isClickable = false
        binding.imgPvpPlayer2Paper.isClickable = false
        binding.imgPvpPlayer2Scissor.isClickable = false
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
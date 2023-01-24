package com.example.binarsuit

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val rockButton = findViewById<ImageView>(R.id.rock_btn)
        val rockButton1 = findViewById<ImageView>(R.id.rock1_btn)

        val paperButton = findViewById<ImageView>(R.id.paper_btn)
        val paperButton1 = findViewById<ImageView>(R.id.paper1_btn)

        val scissorButton = findViewById<ImageView>(R.id.scissor_btn)
        val scissorButton1 = findViewById<ImageView>(R.id.scissor1_btn)

        val restartButton = findViewById<ImageView>(R.id.restart_btn)

        val showText = findViewById<TextView>(R.id.vs)

        //Rock Button
        rockButton.setOnClickListener{
            rockButton.setBackgroundColor(Color.CYAN)
            Log.i("Main Activity", "Player choose ROCK")

            when ((1..3).random()) {
                1 -> {
                    rockButton1.setBackgroundColor(Color.CYAN)

                    showText.text = "DRAW"
                    showText.textSize = 20.0f
                    showText.setBackgroundColor(Color.BLUE)
                    showText.setTextColor(Color.WHITE)
                    Log.i("Main Activity", "Player: ROCK")
                    Log.i("Main Activity", "Computer: ROCK")
                    Log.i("Main Activity", "Result: DRAW")
                }
                2 -> {
                    paperButton1.setBackgroundColor(Color.CYAN)

                    showText.text = "Computer WIN"
                    showText.textSize = 20.0f
                    showText.setBackgroundColor(Color.GREEN)
                    showText.setTextColor(Color.WHITE)
                    Log.i("Main Activity", "Player: ROCK")
                    Log.i("Main Activity", "Computer: PAPER")
                    Log.i("Main Activity", "Result: COMPUTER WIN")
                }
                else -> {
                    scissorButton1.setBackgroundColor(Color.CYAN)

                    showText.text = "Player WIN"
                    showText.textSize = 20.0f
                    showText.setBackgroundColor(Color.GREEN)
                    showText.setTextColor(Color.WHITE)
                    Log.i("Main Activity", "Player: ROCK")
                    Log.i("Main Activity", "Computer: SCISSOR")
                    Log.i("Main Activity", "Result: PLAYER WIN")
                }
            }
            rockButton.isClickable = false
            paperButton.isClickable = false
            scissorButton.isClickable = false
        }

        //Paper Button
        paperButton.setOnClickListener{
            paperButton.setBackgroundColor(Color.CYAN)
            Log.i("Main Activity", "Player choose PAPER")

            when ((1..3).random()) {
                1 -> {
                    rockButton1.setBackgroundColor(Color.CYAN)

                    showText.text = "Player WIN"
                    showText.textSize = 20.0f
                    showText.setBackgroundColor(Color.GREEN)
                    showText.setTextColor(Color.WHITE)
                    Log.i("Main Activity", "Player: PAPER")
                    Log.i("Main Activity", "Computer: ROCK")
                    Log.i("Main Activity", "Result: PLAYER WIN")
                }
                2 -> {
                    paperButton1.setBackgroundColor(Color.CYAN)

                    showText.text = "DRAW"
                    showText.textSize = 20.0f
                    showText.setBackgroundColor(Color.BLUE)
                    showText.setTextColor(Color.WHITE)
                    Log.i("Main Activity", "Player: PAPER")
                    Log.i("Main Activity", "Computer: PAPER")
                    Log.i("Main Activity", "Result: DRAW")
                }
                else -> {
                    scissorButton1.setBackgroundColor(Color.CYAN)

                    showText.text = "Computer WIN"
                    showText.textSize = 20.0f
                    showText.setBackgroundColor(Color.GREEN)
                    showText.setTextColor(Color.WHITE)
                    Log.i("Main Activity", "Player: PAPER")
                    Log.i("Main Activity", "Computer: SCISSOR")
                    Log.i("Main Activity", "Result: COMPUTER WIN")
                }
            }
            rockButton.isClickable = false
            paperButton.isClickable = false
            scissorButton.isClickable = false
        }

        //Scissor Button
        scissorButton.setOnClickListener{
            scissorButton.setBackgroundColor(Color.CYAN)
            Log.i("Main Activity", "Player choose SCISSOR")

            when ((1..3).random()) {
                1 -> {
                    rockButton1.setBackgroundColor(Color.CYAN)

                    showText.text = "Computer WIN"
                    showText.textSize = 20.0f
                    showText.setBackgroundColor(Color.GREEN)
                    showText.setTextColor(Color.WHITE)
                    Log.i("Main Activity", "Player: SCISSOR")
                    Log.i("Main Activity", "Computer: ROCK")
                    Log.i("Main Activity", "Result: COMPUTER WIN")
                }
                2 -> {
                    paperButton1.setBackgroundColor(Color.CYAN)

                    showText.text = "Player WIN"
                    showText.textSize = 20.0f
                    showText.setBackgroundColor(Color.GREEN)
                    showText.setTextColor(Color.WHITE)
                    Log.i("Main Activity", "Player: SCISSOR")
                    Log.i("Main Activity", "Computer: PAPER")
                    Log.i("Main Activity", "Result: PLAYER WIN")
                }
                else -> {
                    scissorButton1.setBackgroundColor(Color.CYAN)

                    showText.text = "DRAW"
                    showText.textSize = 20.0f
                    showText.setBackgroundColor(Color.BLUE)
                    showText.setTextColor(Color.WHITE)
                    Log.i("Main Activity", "Player: SCISSOR")
                    Log.i("Main Activity", "Computer: SCISSOR")
                    Log.i("Main Activity", "Result: DRAW")
                }
            }
            rockButton.isClickable = false
            paperButton.isClickable = false
            scissorButton.isClickable = false
        }

        //Restart Button
        restartButton.setOnClickListener{
            restartApp()
        }

    }

    //Restart function, finish the activity and startActivity again
    private fun restartApp(){
        finish()
        startActivity(intent)
    }
}
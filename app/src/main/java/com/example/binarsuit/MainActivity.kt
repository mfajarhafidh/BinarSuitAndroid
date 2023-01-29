package com.example.binarsuit

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
        
        val rockButtonPlayer = findViewById<ImageView>(R.id.img_player_rock)
        val rockButtonCom = findViewById<ImageView>(R.id.img_com_rock)

        val paperButtonPlayer = findViewById<ImageView>(R.id.img_player_paper)
        val paperButtonCom = findViewById<ImageView>(R.id.img_com_paper)

        val scissorButtonPlayer = findViewById<ImageView>(R.id.img_player_scissor)
        val scissorButtonCom = findViewById<ImageView>(R.id.img_com_scissor)


        //Rock ImageView
        rockButtonPlayer.setOnClickListener{
            rockButtonPlayer.setBackgroundColor(Color.CYAN)
            Log.i("Main Activity", "Player choose ROCK")

            when ((1..3).random()) {
                1 -> {
                    rockButtonCom.setBackgroundColor(Color.CYAN)

                    textDraw()

                    Log.i("Main Activity", "Player: ROCK")
                    Log.i("Main Activity", "Computer: ROCK")
                    Log.i("Main Activity", "Result: DRAW")
                }
                2 -> {
                    paperButtonCom.setBackgroundColor(Color.CYAN)

                    textComWin()

                    Log.i("Main Activity", "Player: ROCK")
                    Log.i("Main Activity", "Computer: PAPER")
                    Log.i("Main Activity", "Result: COMPUTER WIN")
                }
                else -> {
                    scissorButtonCom.setBackgroundColor(Color.CYAN)

                    textPlayerWin()

                    Log.i("Main Activity", "Player: ROCK")
                    Log.i("Main Activity", "Computer: SCISSOR")
                    Log.i("Main Activity", "Result: PLAYER WIN")
                }
            }
            notClickableBtn()
        }

        //Paper ImageView
        paperButtonPlayer.setOnClickListener{
            paperButtonPlayer.setBackgroundColor(Color.CYAN)
            Log.i("Main Activity", "Player choose PAPER")

            when ((1..3).random()) {
                1 -> {
                    rockButtonCom.setBackgroundColor(Color.CYAN)

                    textPlayerWin()

                    Log.i("Main Activity", "Player: PAPER")
                    Log.i("Main Activity", "Computer: ROCK")
                    Log.i("Main Activity", "Result: PLAYER WIN")
                }
                2 -> {
                    paperButtonCom.setBackgroundColor(Color.CYAN)

                    textDraw()

                    Log.i("Main Activity", "Player: PAPER")
                    Log.i("Main Activity", "Computer: PAPER")
                    Log.i("Main Activity", "Result: DRAW")
                }
                else -> {
                    scissorButtonCom.setBackgroundColor(Color.CYAN)

                    textComWin()

                    Log.i("Main Activity", "Player: PAPER")
                    Log.i("Main Activity", "Computer: SCISSOR")
                    Log.i("Main Activity", "Result: COMPUTER WIN")
                }
            }
            notClickableBtn()
        }

        //Scissor ImageView
        scissorButtonPlayer.setOnClickListener{
            scissorButtonPlayer.setBackgroundColor(Color.CYAN)
            Log.i("Main Activity", "Player choose SCISSOR")

            when ((1..3).random()) {
                1 -> {
                    rockButtonCom.setBackgroundColor(Color.CYAN)

                    textComWin()

                    Log.i("Main Activity", "Player: SCISSOR")
                    Log.i("Main Activity", "Computer: ROCK")
                    Log.i("Main Activity", "Result: COMPUTER WIN")
                }
                2 -> {
                    paperButtonCom.setBackgroundColor(Color.CYAN)

                    textPlayerWin()

                    Log.i("Main Activity", "Player: SCISSOR")
                    Log.i("Main Activity", "Computer: PAPER")
                    Log.i("Main Activity", "Result: PLAYER WIN")
                }
                else -> {
                    scissorButtonCom.setBackgroundColor(Color.CYAN)

                    textDraw()

                    Log.i("Main Activity", "Player: SCISSOR")
                    Log.i("Main Activity", "Computer: SCISSOR")
                    Log.i("Main Activity", "Result: DRAW")
                }
            }
            notClickableBtn()
        }

        //Restart ImageView
        restartApp()

    }

    //Restart function, finish the activity and startActivity again
    private fun restartApp(){
        val restartButton = findViewById<ImageView>(R.id.img_restart)

        restartButton.setOnClickListener {
            finish()
            startActivity(intent)
        }

    }

    private fun notClickableBtn(){
        val rockButtonPlayer = findViewById<ImageView>(R.id.img_player_rock)
        val paperButtonPlayer = findViewById<ImageView>(R.id.img_player_paper)
        val scissorButtonPlayer = findViewById<ImageView>(R.id.img_player_scissor)

        rockButtonPlayer.isClickable = false
        paperButtonPlayer.isClickable = false
        scissorButtonPlayer.isClickable = false
    }

    private fun textPlayerWin(){
        val showText = findViewById<TextView>(R.id.tx_vs)

        showText.text = "Player WIN"
        showText.textSize = 20.0f
        showText.setBackgroundColor(Color.GREEN)
        showText.setTextColor(Color.WHITE)
    }

    private fun textComWin(){
        val showText = findViewById<TextView>(R.id.tx_vs)

        showText.text = "Computer WIN"
        showText.textSize = 20.0f
        showText.setBackgroundColor(Color.GREEN)
        showText.setTextColor(Color.WHITE)
    }

    private fun textDraw(){
        val showText = findViewById<TextView>(R.id.tx_vs)

        showText.text = "DRAW"
        showText.textSize = 20.0f
        showText.setBackgroundColor(Color.GREEN)
        showText.setTextColor(Color.WHITE)
    }
}
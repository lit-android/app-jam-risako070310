package com.risako070310.tapgame

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var number = Random.nextInt(11)
    private var count = 0

    private var btn = listOf<Button>()

    val handler = Handler(Looper.getMainLooper())
    val run = object : Runnable{
        override fun run() {
            resetColor()
            randomColor()
            when {
                count < 10 -> {
                    handler.postDelayed(this, 1000)
                }
                count < 20 -> {
                    handler.postDelayed(this, 800)
                }
                else -> {
                    handler.postDelayed(this, 500)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler.post(run)

        btn = listOf(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12)

        btn.forEachIndexed { index, btn ->
            btn.setOnClickListener {
                checkColor(index)
            }
        }

    }

    private fun checkColor(button: Int){
        if(number == button){
            count++
            text.text = count.toString()
            resetColor()
        }
    }

    private fun randomColor(){
        number = Random.nextInt(11)
        btn[number].setBackgroundColor(Color.parseColor("#03dac6"))
    }

    private fun resetColor(){
        for(i in btn){
            i.setBackgroundColor(Color.parseColor("#aaaaaa"))
        }
    }
}

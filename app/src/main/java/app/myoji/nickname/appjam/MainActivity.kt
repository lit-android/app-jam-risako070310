package app.myoji.nickname.appjam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count = 0

        plusButton.setOnClickListener {
            count++
            text.text = count.toString()
        }

        minusButton.setOnClickListener {
            if(count > 0){
                count--
            }
            text.text = count.toString()
        }

        clearButton.setOnClickListener {
            count = 0
            text.text = count.toString()
        }
    }

}

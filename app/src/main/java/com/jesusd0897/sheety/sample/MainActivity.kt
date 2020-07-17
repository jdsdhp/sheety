package com.jesusd0897.sheety.sample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jesusd0897.sheety.SheetyBuilder
import com.jesusd0897.sheety.util.SafeClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        show_btn.setOnClickListener {
            SheetyBuilder(this)
                .title("SheetyDialog")
                .item("Item One", android.R.drawable.star_big_on,
                    SafeClickListener {
                        Toast.makeText(this, "Item One clicked!", Toast.LENGTH_SHORT).show()
                    })
                .item("Item Two", android.R.drawable.star_big_off,
                    SafeClickListener {
                        Toast.makeText(this, "Item Two clicked!", Toast.LENGTH_SHORT).show()
                    })
                .show()
        }

    }
}
/*
 * Copyright (c) 2020 jesusd0897.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
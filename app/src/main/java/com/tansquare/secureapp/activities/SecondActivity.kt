package com.tansquare.secureapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tansquare.secureapp.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle: Bundle? = intent.extras
        val userMessage: String = bundle!!.getString("user_message")
        Toast.makeText(this, userMessage, Toast.LENGTH_SHORT).show()

    }
}

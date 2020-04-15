package com.tansquare.secureapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tansquare.secureapp.Constants
import com.tansquare.secureapp.R
import com.tansquare.secureapp.showToast

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle: Bundle? = intent.extras
        bundle?.let {
            val userMessage: String = bundle.getString(Constants.USER_MSG_KEY)
            showToast(userMessage)
        }

    }
}

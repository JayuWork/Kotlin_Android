package com.tansquare.secureapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.tansquare.secureapp.*
import com.tansquare.secureapp.observers.MainActivityObserver
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initActivity()
    }

    private fun initActivity() {
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)


        lifecycle.addObserver(MainActivityObserver())
        tvViewModelDemo.text = MainActivityViewModel.mRandonNumber

        btn_show_toast.setOnClickListener {
            Helper.log("Button click event captured")

            showToast(" Toast Example ")
        }
        btnSendMessage.setOnClickListener {
            val userMessage = etUserMessage.text.toString()
            showToast(userMessage)

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.USER_MSG_KEY, userMessage)
            startActivity(intent)

        }
        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this, RecyclerViewDemoActivity::class.java)
            startActivity(intent)
        }
    }

}
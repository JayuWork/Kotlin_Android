package com.tansquare.secureapp

import android.content.Context
import android.util.Log
import android.widget.Toast

fun Context.showToast(msg: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, length).show()
}

fun Log.logj(msg: String) {
    Log.d("JU_REBORN", msg)
}
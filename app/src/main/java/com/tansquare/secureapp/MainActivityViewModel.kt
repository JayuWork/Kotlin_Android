package com.tansquare.secureapp

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {


    init {
        mRandonNumber = "Random Number is : " + (0..1000).random()
    }

    companion object {
        var mRandonNumber: String = ""
    }

    override fun onCleared() {
        super.onCleared()
        Helper.log("OnCleared Class")
    }
}
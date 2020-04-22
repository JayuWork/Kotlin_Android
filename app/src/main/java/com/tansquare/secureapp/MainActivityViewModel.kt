package com.tansquare.secureapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {


    init {
        mRandonNumberLiveData.postValue(mRandomNumber)
    }

    fun getNumber(createNew: Boolean = false): LiveData<String> {
//        Log.d("JU_LOG", "getNumber Called $mRandomNumber")
        if (createNew) {
            mRandomNumber = getRandomNumber()
            mRandonNumberLiveData.postValue(mRandomNumber)
//            Log.d("JU_LOG", "getNumber with create new Called")
        }
        return mRandonNumberLiveData
    }


    companion object {
        var mRandonNumberLiveData: MutableLiveData<String> = MutableLiveData()
        var mRandomNumber: String = getRandomNumber()

        fun getRandomNumber(): String {
            return "Random Number is : " + (0..1000).random()
        }
    }

    override fun onCleared() {
        super.onCleared()
        Helper.log("OnCleared Class")
    }
}
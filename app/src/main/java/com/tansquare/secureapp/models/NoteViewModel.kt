package com.tansquare.secureapp.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class NoteViewModel(application: Application) : AndroidViewModel(application) {


    @Override
    override fun onCleared() {
        super.onCleared()
    }
}
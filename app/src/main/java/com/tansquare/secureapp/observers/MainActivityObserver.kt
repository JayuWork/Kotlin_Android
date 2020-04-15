package com.tansquare.secureapp.observers

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.tansquare.secureapp.Helper

class MainActivityObserver : LifecycleObserver {

    val TAG = MainActivityObserver::class.java.simpleName

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreateEvent() {
        Helper.log("OnCreated Event triggered")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAnyEvent() {
//        Helper.log("onAnyEvent Event triggered")
    }
}
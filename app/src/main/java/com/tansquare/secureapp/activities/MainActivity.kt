package com.tansquare.secureapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tansquare.secureapp.*
import com.tansquare.secureapp.models.NoteViewModel
import com.tansquare.secureapp.observers.MainActivityObserver
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {


//    0. Kotlin
//    1. Room database
//    2. Jobservices
//    3. Work Manager
//    4. Dagger
//    5. MVVM architecture
//    6. Data binding


    lateinit var mNoteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initActivity()
    }

    private fun initActivity() {
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        ViewModelProviders.of(this).get(NoteViewModel::class.java)

        mNoteViewModel = NoteViewModel(application)

        var model = MainActivityViewModel()

        lifecycle.addObserver(MainActivityObserver())
        val rndNumber: LiveData<String> = model.getNumber()

        // Create the observer which updates the UI.
        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            tvViewModelDemo.text = newName
        }

        rndNumber.observe(this, nameObserver)
        btn_update_data.setOnClickListener {
            model.getNumber(true)
        }
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
        Helper.log(" Value = ${rndNumber.value}")

        btn_coroutine.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                getDataAndUpdateUI()
            }
        }

    }

    fun setTextToLabel(textResult: String) {
        textResult?.let {
            tvViewModelDemo.text = textResult
        }
    }

    suspend fun getDataAndUpdateUI() {
        val result = getDataFromDB()
        withContext(Dispatchers.Main) {
            setTextToLabel(result)
        }
    }


    suspend fun getDataFromDB(): String {
        val data = " fake data 1 "
        delay(1000)
        return data
    }

}
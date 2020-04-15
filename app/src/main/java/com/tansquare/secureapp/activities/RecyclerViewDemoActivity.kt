package com.tansquare.secureapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tansquare.secureapp.R
import com.tansquare.secureapp.adapters.RecyclerAdapter
import com.tansquare.secureapp.models.RecylerDataList
import kotlinx.android.synthetic.main.activity_recycler_view_demo.*

class RecyclerViewDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_demo)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerViewDemo.layoutManager = layoutManager

        val adapter = RecyclerAdapter(
            this,
            RecylerDataList.listItems
        )
        recyclerViewDemo.adapter = adapter

    }
}

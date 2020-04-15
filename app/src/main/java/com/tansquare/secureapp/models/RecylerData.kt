package com.tansquare.secureapp.models

data class RecylerData(var title: String)

object RecylerDataList {
    val listItems = listOf<RecylerData>(
        RecylerData("First Item"),
        RecylerData("Second Item"),
        RecylerData("Third Item")
    )
}
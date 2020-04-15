package com.tansquare.secureapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.tansquare.secureapp.R
import com.tansquare.secureapp.models.RecylerData
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerAdapter(val context: Context, val listItems: List<RecylerData>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currentItem: RecylerData? = null
        var currentPosition = 0

        init {
            itemView.setOnClickListener {
                Toast.makeText(context, currentItem!!.title, Toast.LENGTH_SHORT).show()
            }
        }

        fun setData(data: RecylerData?, position: Int) {
            itemView.txvTitle.text = data!!.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = listItems.get(position)
        holder.setData(item, position)

    }
}
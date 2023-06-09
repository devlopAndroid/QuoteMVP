package com.opentechspace.quotemvp.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.opentechspace.quotemvp.ApiModel.Result
import com.opentechspace.quotemvp.R

class CustomAdapter(private val context : Context , private val list : List<Result>): RecyclerView.Adapter<CustomAdapter.MYViewHolder>() {

    class MYViewHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        var title = view.findViewById<TextView>(R.id.title)
        var Author = view.findViewById<TextView>(R.id.Author)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MYViewHolder {
       val createView = LayoutInflater.from(context).inflate(R.layout.custom,parent,false)
        return MYViewHolder(createView)
    }

    override fun onBindViewHolder(holder: MYViewHolder, position: Int) {
        val data = list[position]
        holder.title.text = data.content
        holder.Author.text = data.author
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
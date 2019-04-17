package com.emedinaa.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emedinaa.viewmodel.R

class ItemAdapter(var items:MutableList<Item>):RecyclerView.Adapter<ItemAdapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item= items[position]
        holder.textView.text= item.name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return  items.size
    }

    fun addItem(item: Item){
        items.add(item)
        notifyItemInserted((items.size-1))
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val textView = view.findViewById<TextView>(R.id.textView)
    }
}
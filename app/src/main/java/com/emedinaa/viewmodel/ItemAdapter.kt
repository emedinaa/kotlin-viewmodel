package com.emedinaa.viewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Eduardo Medina
 */
class ItemAdapter(private var items: MutableList<Item>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    fun addItem(item: Item) {
        items.add(item)
        notifyItemInserted((items.size - 1))
    }

    fun updateItems(items: List<Item>) {
        this.items = items.toMutableList()
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView = view.findViewById<TextView>(R.id.textView)

        fun bind(item: Item) {
            textView.text = item.name
        }
    }
}
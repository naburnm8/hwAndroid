package ru.naburnm8.bmstu.android.hw1kotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.naburnm8.bmstu.android.hw1kotlin.R

class SquareAdapter(private val context: Context, private val items: MutableList<Int>) :
    RecyclerView.Adapter<SquareAdapter.SquareViewHolder>() {

    inner class SquareViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SquareViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_square, parent, false)
        return SquareViewHolder(view)
    }

    override fun onBindViewHolder(holder: SquareViewHolder, position: Int) {
        val number = items[position]
        holder.textView.text = number.toString()
        if (number % 2 == 0) {
            holder.textView.setBackgroundColor(context.getColor(R.color.red))
        } else {
            holder.textView.setBackgroundColor(context.getColor(R.color.blue))
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItem() {
        items.add(items.size)
        notifyItemInserted(items.size - 1)
    }
}


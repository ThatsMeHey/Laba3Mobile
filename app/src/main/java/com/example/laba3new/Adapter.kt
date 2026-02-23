package com.example.laba3new

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdviceAdapter(private val items: List<Item>) :
    RecyclerView.Adapter<AdviceAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val day: TextView = view.findViewById(R.id.tvDay)
        val image: ImageView = view.findViewById(R.id.tvImage)
        val title: TextView = view.findViewById(R.id.tvTitle)
        val description: TextView = view.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        Glide.with(holder.itemView.context)
            .load(item.imageRes)
            .override(800, 600)
            .into(holder.image)
        holder.title.setText(item.titleRes)
        holder.description.setText(item.descriptionRes)
        holder.day.setText(item.day)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("position", position)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = items.size
}
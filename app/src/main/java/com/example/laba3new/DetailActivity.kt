package com.example.laba3new

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailed_item)

        val position = intent.getIntExtra("position", 0)
        val items = createAdvices(this)
        val item = items[position]

        val day = findViewById<TextView>(R.id.detailDay)
        val title = findViewById<TextView>(R.id.detailTitle)
        val description = findViewById<TextView>(R.id.detailDescription)
        val image = findViewById<ImageView>(R.id.detailImage)

        day.setText(item.day)
        title.setText(item.titleRes)
        description.setText(item.descriptionRes)
        Glide.with(this).load(item.imageRes).into(image)
    }
}
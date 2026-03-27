package com.example.laba3new

import android.content.Context

data class Item(
    val day: String,
    val imageRes: Int,
    val titleRes: Int,
    val descriptionRes: Int
)

fun createAdvices(context: Context): List<Item> {
    return (1..30).map { i ->
        Item(
            day = context.getString(R.string.day, i),
            imageRes = context.resources.getIdentifier("img_$i", "drawable", context.packageName),
            titleRes = context.resources.getIdentifier("title$i", "string", context.packageName),
            descriptionRes = context.resources.getIdentifier("desc$i", "string", context.packageName)
        )
    }
}
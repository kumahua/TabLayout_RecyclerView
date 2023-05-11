package com.example.recyclerview_demo

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_demo.databinding.ItemListContentBinding

class ContentHolder(
    private val context: Context, private val v: ItemListContentBinding) :
    RecyclerView.ViewHolder(v.root) {

    fun setResult(response: ListResponse) {

        v.title.text = response.noData
        v.content.text = response.accountType
    }
}
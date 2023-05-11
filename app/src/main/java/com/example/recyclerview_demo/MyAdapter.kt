package com.example.recyclerview_demo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_demo.databinding.ItemListContentBinding

class MyAdapter(private val context: Context, private val data: List<ListResponse>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val viewBinding = ItemListContentBinding.inflate(LayoutInflater.from(context), parent, false)
        return ContentHolder(context, viewBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is ContentHolder) {

            holder.setResult(data[position])
        }
    }

    override fun getItemCount() = data.count()
}
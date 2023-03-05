package com.example.laba2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class MyRecyclerViewAdapter(mData: List<String>) :
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>(){

    private var mDataset:List<String>
    init{
        mDataset = mData
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mTextureView = itemView.findViewById<TextView>(R.id.text1)

        }







    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_item, parent, false)

        var vh: MyViewHolder = MyViewHolder(itemView)
        return  vh
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mTextureView.text = mDataset[position]
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }
}
package com.onedelay.calendardiary.fragment

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.onedelay.calendardiary.R
import com.onedelay.calendardiary.fragment.model.DailyItem

class DailyListItemRecyclerviewAdapter(private val items: ArrayList<DailyItem>, private val context: Context) : RecyclerView.Adapter<DailyListItemRecyclerviewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.daily_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setItem(items[position])
    }

    fun addItem(item: DailyItem){
        items.add(item)
    }

    inner class ViewHolder(private val mView: View) : RecyclerView.ViewHolder(mView){
        private val mSticker: ImageView = mView.findViewById(R.id.sticker)
        private val mCategory: TextView = mView.findViewById(R.id.category)

        fun setItem(item: DailyItem){
            mSticker.setImageResource(item.sticker)
            mCategory.text = item.category
        }
    }
}
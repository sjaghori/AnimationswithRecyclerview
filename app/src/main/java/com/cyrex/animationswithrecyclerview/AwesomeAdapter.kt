package com.cyrex.animationswithrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.awesome_item.view.*

class AwesomeAdapter : ListAdapter<Beer, AwesomeAdapter.ViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.awesome_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.name.text = item.name
        holder.tagLine.text = item.tagLine
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.awesome_name
        val tagLine: TextView = itemView.awesome_tag_line
    }

    class DiffCallBack : DiffUtil.ItemCallback<Beer>() {

        override fun areItemsTheSame(oldItem: Beer, newItem: Beer): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Beer, newItem: Beer): Boolean {
            return oldItem == newItem
        }
    }

}
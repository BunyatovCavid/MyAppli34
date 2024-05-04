package com.example.myappli.fragments

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.myappli.ItemData
import com.example.myappli.R

class ItemAdapter(private val items:List<ItemData>):RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

     class ViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView){
         val image: ImageView = itemView.findViewById(R.id.avatar)
         val title: TextView = itemView.findViewById(R.id.title)
         val address: TextView = itemView.findViewById(R.id.address)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val i = items[position]

      //  holder.image = (i.imageUrl)
        holder.title.text=i.name
        holder.address.text=i.address
    }
}
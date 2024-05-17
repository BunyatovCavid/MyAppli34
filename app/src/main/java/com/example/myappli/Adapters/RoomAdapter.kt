package com.example.myappli.Adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myappli.Interfaces.Costumer
import com.example.myappli.R
import com.squareup.picasso.Picasso

class RoomAdapter(var datas:List<Costumer>): RecyclerView.Adapter<RoomAdapter.ViewHolder>() {


    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val image:ImageView = ItemView.findViewById(R.id.rcimage)
        val name:TextView = ItemView.findViewById(R.id.rcname)
        val description:TextView = ItemView.findViewById(R.id.rcdescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.room_view, parent, false)

        return RoomAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return datas.size
    }

    override fun onBindViewHolder(holder: RoomAdapter.ViewHolder, position: Int) {
      var data = datas[position]

        Picasso.get().load(Uri.parse(data.logoUrl)).into(holder.image)
        holder.name.text = data.name
        holder.description.text = data.description
    }

}
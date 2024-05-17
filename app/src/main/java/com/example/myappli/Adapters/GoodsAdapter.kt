package com.example.myappli.Adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myappli.DataClasses.Goods
import com.example.myappli.R
import com.squareup.picasso.Picasso

class GoodsAdapter(val datas:List<Goods>): RecyclerView.Adapter<GoodsAdapter.ViewHolder>()  {

    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        val mainimage :ImageView =ItemView.findViewById(R.id.goodsimage)
        val title:TextView = ItemView.findViewById(R.id.goodstext)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.myitems_view, parent, false)

        return GoodsAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
      return datas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = datas[position]

        Picasso.get().load(
            Uri.parse(data.image)).into(holder.mainimage)
        holder.title.text=data.name


    }


}
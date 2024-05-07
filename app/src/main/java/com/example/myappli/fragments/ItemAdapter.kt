package com.example.myappli.fragments

import android.annotation.SuppressLint
import android.media.Image
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.databinding.adapters.ViewGroupBindingAdapter
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myappli.ItemData
import com.example.myappli.R
import com.squareup.picasso.Picasso
import java.util.zip.Inflater


class ItemAdapter(private val items:List<ItemData>, var listener : ItemAdapter.OnItemClickListener):RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun alertDialog(position : Int)
    }


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

    @SuppressLint("RestrictedApi")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val i = items[position]

         Picasso.get().load(Uri.parse(i.imageUrl)).into(holder.image)

        holder.title.text=i.name
        holder.address.text=i.address
    }

    inner class ItemDataViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView),
        View.OnClickListener {
        init {
            containerView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.alertDialog(adapterPosition)
        }
    }

}
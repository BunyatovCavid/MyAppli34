package com.example.myappli.Adapters

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myappli.DataClasses.Brand
import com.example.myappli.R
import com.example.myappli.fragments.ItemAdapter
import com.squareup.picasso.Picasso

class BrandAdapter(var datas:List<Brand>): RecyclerView.Adapter<BrandAdapter.ViewHolder>() {


    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        val image: ImageView = itemView.findViewById(R.id.brandimage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.brand_view, parent, false)

        return BrandAdapter.ViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("TESTDATA","$datas")
        return datas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = datas[position]
        Log.d("ASSINGDATA","$datas")
        Picasso.get().load(Uri.parse(data.image)).into(holder.image)
    }


}
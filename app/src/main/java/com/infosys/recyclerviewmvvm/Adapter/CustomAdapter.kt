package com.infosys.app.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.infosys.app.models.ItemRow
import com.infosys.recyclerviewmvvm.R
import com.squareup.picasso.Picasso

class CustomAdapter(private val mContext: Context, private var itemsList: List<ItemRow>) :
        RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTextView: TextView = view.findViewById(R.id.itemTitle)
        var itemDescription: TextView = view.findViewById(R.id.itemDescription)
        var image_main: ImageView = view.findViewById(R.id.image_main)
        var image_arrow: ImageView = view.findViewById(R.id.image_arrow)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.items, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        val title = item.title
        val description = item.description
        val image = item.imageHref
        if (title.isNotEmpty() && title != "null"){
            holder.itemTextView.text = item.title
        }
        if (description.isNotEmpty() && description != "null") {
            holder.itemDescription.text = item.description
        }
        try {
            if (image != 0){
                Glide.with(mContext).asBitmap().load(image).into(holder.image_main)
            }

        }catch (ex:Exception){
            ex.printStackTrace()
        }



        }
    override fun getItemCount(): Int {
        return itemsList.size
    }
}
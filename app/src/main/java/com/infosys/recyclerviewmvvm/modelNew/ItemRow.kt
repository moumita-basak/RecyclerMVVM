package com.infosys.recyclerviewmvvm.modelNew

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target


data class ItemRow(
    val title: String,
    val description: String,
    val imageHref: Int,

    )

@BindingAdapter("imageHref")
fun loadImage(view: ImageView, imageHref: Int?) {
    Glide.with(view.getContext())
        .load(imageHref)
        .into(view)
}

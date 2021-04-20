package com.infosys.app.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.infosys.recyclerviewmvvm.adapter.listener.ClickListener
import com.infosys.recyclerviewmvvm.BR
import com.infosys.recyclerviewmvvm.R
import com.infosys.recyclerviewmvvm.modelNew.ItemRow
import com.infosys.recyclerviewmvvm.databinding.ItemsBinding

/*
class CustomAdapter(private val mContext: Context, private var itemsList: List<ItemRow>) :
        RecyclerView.Adapter<CustomAdapter.MyViewHolder>(), ClickListener {
    */
/*inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTextView: TextView = view.findViewById(R.id.itemTitle)
        var itemDescription: TextView = view.findViewById(R.id.itemDescription)
        var image_main: ImageView = view.findViewById(R.id.image_main)
        var image_arrow: ImageView = view.findViewById(R.id.image_arrow)
    }*//*


   class MyViewHolder(itemRowBinding: ItemRowBinding) :
       RecyclerView.ViewHolder(itemRowBinding.getRoot()) {
       var itemRowBinding: ItemRowBinding
       fun bind(obj: Any?) {
           itemRowBinding.setVariable(BR.model, obj)
           itemRowBinding.executePendingBindings()
       }

       init {
           this.itemRowBinding = itemRowBinding
       }
   }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       */
/* val itemView: ItemRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.items, parent, false
        )*//*

        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.items, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
       */
/* val dataModel: ItemRow = itemsList[position]

        holder.itemRowBinding.setModel(dataModel)
        holder.bind(dataModel)
        holder.itemRowBinding.setItemClickListener(this)*//*

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

        }catch (ex: Exception){
            ex.printStackTrace()
        }



        }
    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun cardClicked(f: ItemRow?) {

    }
}*/
class CustomAdapter(dataModelList: MutableLiveData<ArrayList<ItemRow>>, ctx: Context)
    : RecyclerView.Adapter<CustomAdapter.ViewHolder?>(), ClickListener {
//    private val dataModelList: ArrayList<ItemRow>
    private val dataModelList: MutableLiveData<ArrayList<ItemRow>>
    private val context: Context
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val binding: ItemsBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.items, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel: ItemRow = dataModelList.value!![position]
        holder.itemRowBinding.setModel(dataModel)
        holder.bind(dataModel)
        holder.itemRowBinding.itemClickListener = this
    }

    override fun getItemCount(): Int {
        return dataModelList.value!!.size
    }

    inner class ViewHolder(itemRowBinding: ItemsBinding) : RecyclerView.ViewHolder(itemRowBinding.root) {
        var itemRowBinding: ItemsBinding

        fun bind(obj: Any?) {
            itemRowBinding.setVariable(BR._all, obj)
            itemRowBinding.executePendingBindings()
        }

        init {
            this.itemRowBinding = itemRowBinding
        }
    }

    init {
        this.dataModelList = dataModelList
        context = ctx
    }

    override fun cardClicked(f: ItemRow?) {

    }
}
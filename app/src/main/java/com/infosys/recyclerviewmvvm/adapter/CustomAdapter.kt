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
            itemRowBinding.setVariable(BR.model, obj)
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
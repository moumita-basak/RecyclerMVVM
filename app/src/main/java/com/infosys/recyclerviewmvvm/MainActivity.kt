package com.infosys.recyclerviewmvvm

import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.infosys.app.Adapter.CustomAdapter
import com.infosys.recyclerviewmvvm.databinding.ActivityMainBinding
import com.infosys.recyclerviewmvvm.modelNew.ItemRow
import com.infosys.recyclerviewmvvm.ui.LiveDataMVVM

class MainActivity : AppCompatActivity() {
private lateinit var binding: ActivityMainBinding
//    private val itemsList = ArrayList<ItemRow>()
    var dataList= MutableLiveData<ArrayList<ItemRow>>()
    lateinit  var da:ArrayList<ItemRow>
    private lateinit var customAdapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        customAdapter = CustomAdapter(dataList, this@MainActivity)
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.itemAnimator = DefaultItemAnimator()

        val model = ViewModelProviders.of(this).get(LiveDataMVVM::class.java)
        model.getItemList().observe(this, Observer<ArrayList<ItemRow>>{ itemList ->
            // update UI
            dataList.value=itemList as ArrayList<ItemRow>
            da=itemList!!
            Log.d("MainActivity ","Data Send"+dataList.value!!.size.toString())
            customAdapter = CustomAdapter(dataList, this@MainActivity)
            binding.recyclerView.adapter = customAdapter

        })

    }

    }


package com.emedinaa.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.emedinaa.viewmodel.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var item:String?=null
    private lateinit var viewModel: ItemViewModel
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ItemViewModel::class.java)
        val observer = Observer<MutableList<Item>>{
            adapter.updateItems()
        }
        viewModel.getItems().observe(this,observer)

        //ui
        adapter= ItemAdapter(viewModel.getItems().value?: mutableListOf())
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter= adapter

        buttonAdd.setOnClickListener {
            item= editText.text.toString()
            item?.let {itemIt->
                viewModel.addItem(Item(itemIt))
                editText.text.clear()
            }
        }
    }
}

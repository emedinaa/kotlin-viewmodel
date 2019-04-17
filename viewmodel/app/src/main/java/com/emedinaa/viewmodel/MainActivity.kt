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

        val observer = Observer<String>{
            adapter.addItem(Item(it))
        }
        viewModel.item.observe(this,observer)

        //ui
        recyclerView.layoutManager= LinearLayoutManager(this)
        adapter= ItemAdapter(mutableListOf())
        recyclerView.adapter= adapter

        buttonAdd.setOnClickListener {
            item= editText.text.toString()
            item.let {itemIt->
                viewModel.item.value=itemIt
                editText.text.clear()
            }
        }
    }
}

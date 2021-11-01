package com.emedinaa.viewmodel

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @author Eduardo Medina
 */
class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ItemAdapter

    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonAdd: Button
    private lateinit var editText: EditText

    private val viewModel: ItemViewModel by viewModels()

    private fun setObservers() {
        viewModel.items.observe(this) {
            if (it != null) {
                adapter.updateItems(it)
            }
            editText.text.clear()
        }
    }

    private fun addItem(name: String) {
        viewModel.addItem(name)
    }

    private fun setupUi() {
        recyclerView = findViewById(R.id.recyclerView)
        buttonAdd = findViewById(R.id.buttonAdd)
        editText = findViewById(R.id.editText)

        adapter = ItemAdapter(mutableListOf())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        buttonAdd.setOnClickListener {
            val name = editText.text.toString().trim()
            addItem(name)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setObservers()
        setupUi()
    }
}

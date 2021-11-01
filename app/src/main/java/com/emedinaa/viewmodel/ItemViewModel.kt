package com.emedinaa.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Eduardo Medina
 */
class ItemViewModel : ViewModel() {

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> = _items

    init {
        _items.value = mutableListOf()
    }

    fun addItem(name: String) {
        if (name.isEmpty()) return

        val tmpItems = items.value?.toMutableList() ?: mutableListOf()
        tmpItems.add(Item(name))
        _items.value = tmpItems

        Log.v("CONSOLE", "items ${_items.value}")
    }
}
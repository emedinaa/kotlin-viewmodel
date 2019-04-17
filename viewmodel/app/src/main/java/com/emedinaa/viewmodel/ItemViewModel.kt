package com.emedinaa.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel:ViewModel() {

    val item: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}
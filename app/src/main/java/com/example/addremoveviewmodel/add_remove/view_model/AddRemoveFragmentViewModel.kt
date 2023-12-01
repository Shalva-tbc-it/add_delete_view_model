package com.example.addremoveviewmodel.add_remove.view_model

import androidx.lifecycle.ViewModel
import com.example.addremoveviewmodel.add_remove.data_model.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AddRemoveFragmentViewModel : ViewModel() {

    private val _dataList = MutableStateFlow<List<Item>>(emptyList())
    val dataList: StateFlow<List<Item>> get() = _dataList

    fun addItem(item: Item) {
        _dataList.value += item
    }

    fun removeItem(item: Item) {
        _dataList.value -= item
    }

}
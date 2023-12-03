package com.example.addremoveviewmodel.add_remove.view_model

import androidx.lifecycle.ViewModel
import com.example.addremoveviewmodel.add_remove.data_model.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AddRemoveFragmentViewModel : ViewModel() {

    private val _dataList = MutableStateFlow<ArrayList<Item>>(
        arrayListOf(
            Item(
                title = "Yancy",
                image = "Error"
            ),
            Item(
                title = "trer",
                image = "Error"
            )
        )
    )
    val dataList: StateFlow<List<Item>> get() = _dataList

    var editDelete: Item? = null

    fun setData(item: Item) {
        editDelete = item

    }

    fun addItem(item: Item) {
        _dataList.value.add(item)
    }

    fun update(item: Item) {
        _dataList.value.remove(editDelete)
        _dataList.value.add(item)
    }


    fun removeItem() {
        _dataList.value.remove(editDelete)
    }


}
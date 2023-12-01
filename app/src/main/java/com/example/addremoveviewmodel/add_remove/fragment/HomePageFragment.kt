package com.example.addremoveviewmodel.add_remove.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.addremoveviewmodel.add_remove.data_model.Item
import com.example.addremoveviewmodel.add_remove.view_model.AddRemoveFragmentViewModel
import com.example.addremoveviewmodel.base.BaseFragment
import com.example.addremoveviewmodel.databinding.FragmentHomePageBinding

class HomePageFragment : BaseFragment<FragmentHomePageBinding>(FragmentHomePageBinding::inflate) {

    private val viewModel: AddRemoveFragmentViewModel by viewModels()

    override fun start() {


    }

    override fun clickListener() = with(binding) {

        swipeToRefresh.setOnRefreshListener {
            Toast.makeText(context, "Page refreshed!", Toast.LENGTH_SHORT).show()
            swipeToRefresh.isRefreshing = false
        }

    }

    private fun  addItem(item: Item) {
        viewModel.addItem(item)
    }

    private fun removeItem(item: Item) {
        viewModel.removeItem(item)
    }

}
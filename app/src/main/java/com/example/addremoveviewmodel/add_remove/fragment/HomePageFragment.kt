package com.example.addremoveviewmodel.add_remove.fragment

import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.addremoveviewmodel.R
import com.example.addremoveviewmodel.add_remove.adapter.ItemRecyclerAdapter
import com.example.addremoveviewmodel.add_remove.view_model.AddRemoveFragmentViewModel
import com.example.addremoveviewmodel.base.BaseFragment
import com.example.addremoveviewmodel.databinding.FragmentHomePageBinding
import kotlinx.coroutines.launch

class HomePageFragment : BaseFragment<FragmentHomePageBinding>(FragmentHomePageBinding::inflate) {

    private val viewModel: AddRemoveFragmentViewModel by activityViewModels()
    private lateinit var adapter: ItemRecyclerAdapter

    override fun start() {
        initAdapter()
    }

    override fun clickListener() = with(binding) {

        swipeToRefresh.setOnRefreshListener {
            Toast.makeText(context, "Page refreshed!", Toast.LENGTH_SHORT).show()
            swipeToRefresh.isRefreshing = false
            adapter.submitList(viewModel.dataList.value)
        }

        btnAddItem.setOnClickListener {
            findNavController().navigate(
                R.id.action_homePageFragment_to_addFragment
            )
        }

        adapter.setOnItemClickListener(
            listener = {
                viewModel.setData(it)
                findNavController().navigate(
                    R.id.action_homePageFragment_to_updateDeleteFragment
                )
            }
        )
    }

    override fun bindObserve() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.dataList.collect {
                    adapter.submitList(it)
                }
            }

        }
    }

    private fun initAdapter() {
        adapter = ItemRecyclerAdapter()
        binding.recyclerItem.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerItem.adapter = adapter
    }

}
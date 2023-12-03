package com.example.addremoveviewmodel.add_remove.fragment

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.addremoveviewmodel.R
import com.example.addremoveviewmodel.add_remove.data_model.Item
import com.example.addremoveviewmodel.add_remove.view_model.AddRemoveFragmentViewModel
import com.example.addremoveviewmodel.base.BaseFragment
import com.example.addremoveviewmodel.databinding.FragmentAddBinding
import kotlinx.coroutines.launch

class AddFragment : BaseFragment<FragmentAddBinding>(FragmentAddBinding::inflate) {

    private val viewModel: AddRemoveFragmentViewModel by activityViewModels()

    //    private val newItem: MutableList<Item> = mutableListOf()
    private var newItem: Item? = null

    override fun start() {

    }

    override fun clickListener() = with(binding) {
        btnAddItem.setOnClickListener {
            if (!edImageLink.text.isNullOrEmpty() || !edImageTitle.text.isNullOrEmpty()) {
                newItem =
                    Item(
                        image = edImageLink.text.toString(),
                        title = edImageTitle.text.toString(),
                    )
                viewLifecycleOwner.lifecycleScope.launch {
                    newItem?.let { viewModel.addItem(item = it) }
                }
                findNavController().navigate(
                    R.id.action_addFragment_to_homePageFragment
                )
            }
        }
    }

    override fun bindObserve() {



    }


}
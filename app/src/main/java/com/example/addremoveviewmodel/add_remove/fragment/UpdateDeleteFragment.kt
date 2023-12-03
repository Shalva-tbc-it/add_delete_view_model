package com.example.addremoveviewmodel.add_remove.fragment

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.addremoveviewmodel.R
import com.example.addremoveviewmodel.add_remove.data_model.Item
import com.example.addremoveviewmodel.add_remove.view_model.AddRemoveFragmentViewModel
import com.example.addremoveviewmodel.base.BaseFragment
import com.example.addremoveviewmodel.databinding.FragmentUpdateDeleteBinding
import kotlinx.coroutines.launch

class UpdateDeleteFragment :
    BaseFragment<FragmentUpdateDeleteBinding>(FragmentUpdateDeleteBinding::inflate) {

    private val viewModel: AddRemoveFragmentViewModel by activityViewModels()
    override fun start() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.editDelete?.let {
                binding.edImageLink.setText(it.image)
                binding.edImageTitle.setText(it.title)
            }
        }
    }

    override fun clickListener() = with(binding) {

        btnUpdate.setOnClickListener {
            if (!edImageLink.text.isNullOrEmpty() || !edImageTitle.text.isNullOrEmpty()) {
                var newItem = Item(
                    image = edImageLink.text.toString(),
                    title = edImageTitle.text.toString(),
                )
                viewLifecycleOwner.lifecycleScope.launch {
                    viewModel.update(item = newItem)
                }
                findNavController().navigate(
                    R.id.action_updateDeleteFragment_to_homePageFragment
                )
            }
        }

        btnDelete.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch{
                viewModel.removeItem()
            }
            findNavController().navigate(
                R.id.action_updateDeleteFragment_to_homePageFragment
            )
        }
    }

    override fun bindObserve() {

    }


}
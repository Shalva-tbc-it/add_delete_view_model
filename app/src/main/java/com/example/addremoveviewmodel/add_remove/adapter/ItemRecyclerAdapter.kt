package com.example.addremoveviewmodel.add_remove.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.addremoveviewmodel.R
import com.example.addremoveviewmodel.add_remove.data_model.Item
import com.example.addremoveviewmodel.databinding.RecyclerItemBinding
import com.squareup.picasso.Picasso

class ItemRecyclerAdapter : ListAdapter<Item, ItemRecyclerAdapter.ItemViewHolder>(object :
    DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }

}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            RecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind()
    }


    inner class ItemViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() = with(binding) {
            val item = currentList[adapterPosition]

            Picasso.get()
                .load(item.image)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(imgPicture)

            tvTitle.text = item.title
        }
    }
}
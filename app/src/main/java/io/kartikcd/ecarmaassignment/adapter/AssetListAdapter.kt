package io.kartikcd.ecarmaassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.kartikcd.ecarmaassignment.databinding.ListAssetBinding
import io.kartikcd.ecarmaassignment.models.Community

class AssetListAdapter: ListAdapter<String, AssetListAdapter.AssetListViewHolder>(AssetDiffUtilCallback) {

    private var onAssetClickListener: ((String) -> Unit) ?= null

    inner class AssetListViewHolder(val binding: ListAssetBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String) {
            binding.apply {
                textCompanyName.text = name
                root.setOnClickListener {
                    onAssetClickListener?.let {
                        it(name)
                    }
                }
            }
        }
    }

    fun setOnAssetClickListener(listener: (String) -> Unit) {
        onAssetClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetListViewHolder {
        val binding = ListAssetBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return AssetListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AssetListViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}

object AssetDiffUtilCallback: DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}
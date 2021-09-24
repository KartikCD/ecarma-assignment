package io.kartikcd.ecarmaassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.kartikcd.ecarmaassignment.R
import io.kartikcd.ecarmaassignment.databinding.ListManpowerBinding

class ManpowerListAdapter: ListAdapter<String, ManpowerListAdapter.ManpowerListViewHolder>(ManPowerDiffUtilCallback) {

    inner class ManpowerListViewHolder(private val binding: ListManpowerBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(manpower: String) {
            binding.apply {
                textPower.text = manpower
                imageviewPower.setOnClickListener {
                    imageviewPower.setImageResource(R.drawable.ic_down_arrow)
                    descriptionCard.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManpowerListViewHolder {
        val binding = ListManpowerBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ManpowerListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ManpowerListViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}

object ManPowerDiffUtilCallback: DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}
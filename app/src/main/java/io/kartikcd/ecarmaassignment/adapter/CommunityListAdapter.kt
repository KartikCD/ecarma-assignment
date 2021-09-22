package io.kartikcd.ecarmaassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.kartikcd.ecarmaassignment.databinding.ListCommunityBinding
import io.kartikcd.ecarmaassignment.models.Community

class CommunityListAdapter: ListAdapter<Community, CommunityListAdapter.CommunityListViewHolder>(CommunityDiffUtilCallback) {

    private var onCommunityClickListener: ((Community) -> Unit) ?= null

    inner class CommunityListViewHolder(val binding: ListCommunityBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(community: Community) {
            binding.apply {
                textCompanyName.text = community.companyName
                if (community.status) {
                    textBoardingStatus.visibility = View.VISIBLE
                } else {
                    textBoardingStatus.visibility = View.INVISIBLE
                }

                root.setOnClickListener {
                    onCommunityClickListener?.let {
                        it(community)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityListViewHolder {
        val binding = ListCommunityBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CommunityListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommunityListViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    fun setOnCommunityClickListener(listener: (Community) -> Unit) {
        onCommunityClickListener = listener
    }
}

object CommunityDiffUtilCallback: DiffUtil.ItemCallback<Community>() {
    override fun areItemsTheSame(oldItem: Community, newItem: Community): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Community, newItem: Community): Boolean {
        return oldItem.companyName == newItem.companyName
    }
}
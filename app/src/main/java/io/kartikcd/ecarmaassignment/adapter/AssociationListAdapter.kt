package io.kartikcd.ecarmaassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.kartikcd.ecarmaassignment.databinding.ListAssociationsBinding
import io.kartikcd.ecarmaassignment.models.Association

class AssociationListAdapter: ListAdapter<Association, AssociationListAdapter.AssociationListViewHolder>(AssociationDiffUtilCallback) {

    inner class AssociationListViewHolder(private val binding: ListAssociationsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(association: Association) {
            binding.apply {
                textPosition.text = association.position
                textName.text = association.name
                textFlat.text = association.flat
                textPhone.text = association.number
                textEmail.text = association.email
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssociationListViewHolder {
        val binding = ListAssociationsBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return AssociationListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AssociationListViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(association = it)
        }
    }
}

object AssociationDiffUtilCallback: DiffUtil.ItemCallback<Association>() {
    override fun areItemsTheSame(oldItem: Association, newItem: Association): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Association, newItem: Association): Boolean {
        return oldItem.name == newItem.name
    }
}
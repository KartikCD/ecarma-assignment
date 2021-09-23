package io.kartikcd.ecarmaassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.kartikcd.ecarmaassignment.R
import io.kartikcd.ecarmaassignment.databinding.ListTasksBinding
import io.kartikcd.ecarmaassignment.models.Task

class TaskListAdapter: ListAdapter<Task, TaskListAdapter.TaskListViewHolder>(TaskDiffUtilCallback) {

    private var onTaskClickListener: ((Task) -> Unit) ?= null

    inner class TaskListViewHolder(private val binding: ListTasksBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.apply {
                if (task.taskName == "Community") {
                    imageviewType.setImageResource(R.drawable.community)
//                    imageviewType.setBackgroundResource(R.drawable.community)
                } else if (task.taskName == "Daily tasks update") {
                    imageviewType.setImageResource(R.drawable.daily_task)
                } else if (task.taskName == "Issues") {
                    imageviewType.setImageResource(R.drawable.issue)
                } else if (task.taskName == "Expenses") {
                    imageviewType.setImageResource(R.drawable.expenses)
                } else if (task.taskName == "Monthly Audit") {
                    imageviewType.setImageResource(R.drawable.audit)
                } else if (task.taskName == "Personal Charter") {
                    imageviewType.setImageResource(R.drawable.charter)
                }

                layoutNotification.isVisible = task.notificationBoolean
                textNotification.text = task.notificationText
                textType.text = task.taskName

                root.setOnClickListener {
                    onTaskClickListener?.let {
                        it(task)
                    }
                }
            }
        }
    }

    fun setOnTaskClickListener(listener: (Task) -> Unit) {
        onTaskClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val binding = ListTasksBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}

object TaskDiffUtilCallback: DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.taskName == newItem.taskName
    }
}
package ru.example.project1.ui.task_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.example.project1.databinding.TaskListItemBinding

class TaskListAdapter(
    private val onItemClick: () -> Unit,
    private val onRbClick: (state: Boolean, position: Int) -> Unit
) : RecyclerView.Adapter<TaskListAdapter.TaskListViewHolder>() {

    private val taskList = mutableListOf<TaskItem>()

    fun setupAdapter(list: List<TaskItem>) {
        taskList.clear()
        taskList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TaskListViewHolder(
            TaskListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount() = taskList.size

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        holder.bind(taskList[position], position)
    }

    inner class TaskListViewHolder(private val binding: TaskListItemBinding) :
        ViewHolder(binding.root) {
        fun bind(item: TaskItem, position: Int) = with(binding) {
            root.setOnClickListener {
                onItemClick()
            }
            tvTaskTitle.text = item.taskTitle
            rbCompletedTask.isChecked = item.state
            rbCompletedTask.setOnClickListener {
                onRbClick(rbCompletedTask.isChecked, position)
            }
        }

    }

}
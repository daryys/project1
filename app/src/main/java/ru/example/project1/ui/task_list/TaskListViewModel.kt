package ru.example.project1.ui.task_list

import androidx.lifecycle.MutableLiveData
import ru.example.project1.core.ui.BaseViewModel
import ru.example.project1.ui.task_list.adapter.TaskItem

class TaskListViewModel : BaseViewModel<TaskListState>() {
    override val state = MutableLiveData(TaskListState())

    fun addTask() {
        state.value?.let {
            val currentList = it.taskList.toMutableList()
            currentList.add(TaskItem(false, "New task"))
            state.value = TaskListState(currentList)
        }
    }

    fun stateChanged(stateItem: Boolean, position: Int) {
        state.value?.let {
            state.value = TaskListState(it.taskList.apply {
                this[position].state = stateItem
            })
        }
    }

}
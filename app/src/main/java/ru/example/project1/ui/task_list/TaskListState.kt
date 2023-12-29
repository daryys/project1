package ru.example.project1.ui.task_list

import ru.example.project1.ui.task_list.adapter.TaskItem

data class TaskListState(val taskList: List<TaskItem> = emptyList())
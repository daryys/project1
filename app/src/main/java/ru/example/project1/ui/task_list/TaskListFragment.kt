package ru.example.project1.ui.task_list

import android.util.Log
import androidx.viewbinding.ViewBinding
import org.koin.androidx.viewmodel.ext.android.stateViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.example.project1.R
import ru.example.project1.core.ui.BaseFragment
import ru.example.project1.core.ui.BaseViewModel
import ru.example.project1.databinding.FragmentTasksListBinding
import ru.example.project1.ui.task_list.adapter.TaskListAdapter

class TaskListFragment : BaseFragment<TaskListState>(R.layout.fragment_tasks_list) {

    override val vm: TaskListViewModel by viewModel()
    private val adapter = TaskListAdapter(
        onItemClick = {
            showToast("Clicked")
        },
        onRbClick = { state, position ->
            vm.stateChanged(state, position)
        })

    override val binding: FragmentTasksListBinding
        get() = setupBinding(FragmentTasksListBinding::bind)

    override fun renderState(state: TaskListState) {
        adapter.setupAdapter(state.taskList)
        Log.d("12345", state.taskList.toString())
    }

    override fun initView() = with(binding) {
        rvTaskList.adapter = adapter
        ibList.setOnClickListener {
            vm.addTask()
        }
    }

}
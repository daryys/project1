package ru.example.project1.ui.folder_list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.example.project1.R
import ru.example.project1.core.ui.BaseFragment
import ru.example.project1.databinding.FragmentFolderListBinding
import ru.example.project1.ui.folder_list.adapter.FolderListAdapter
import ru.example.project1.ui.task_list.TaskListFragment

class FolderListFragment : BaseFragment<FolderListState>(R.layout.fragment_folder_list) {

    private val adapter = FolderListAdapter(
        onItemClick = {
            safeNavigate(requireActivity(), TaskListFragment())
        },
        addItemClick = {
            vm.addFolder()
        }
    )

    override val vm: FolderListViewModel by viewModel()
    override val binding: FragmentFolderListBinding
        get() = setupBinding(FragmentFolderListBinding::bind)

    override fun initView() = with(binding) {
        rvFolderList.layoutManager = GridLayoutManager(requireContext(), 2)
        rvFolderList.adapter = adapter
    }

    override fun renderState(state: FolderListState) {
        adapter.setupAdapter(state.folderList)
    }


}
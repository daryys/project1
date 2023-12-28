package ru.example.project1.ui.folder_list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.example.project1.R
import ru.example.project1.core.ui.BaseFragment
import ru.example.project1.databinding.FragmentFolderListBinding
import ru.example.project1.ui.folder_list.adapter.FolderListAdapter

class FolderListFragment : BaseFragment<FolderListState>(R.layout.fragment_folder_list) {

    private val adapter = FolderListAdapter(
        onItemClick = {
            showToast("Task clicked")
        },
        addItemClick = {
            vm.addFolder()
        }
    )

    override val vm: FolderListViewModel by viewModel()
    override val binding: FragmentFolderListBinding
        get() = setupBinding(FragmentFolderListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        rvFolderList.layoutManager = GridLayoutManager(requireContext(), 2)
        rvFolderList.adapter = adapter
    }

    override fun renderState(state: FolderListState) {
        adapter.setupAdapter(state.folderList)
    }


}
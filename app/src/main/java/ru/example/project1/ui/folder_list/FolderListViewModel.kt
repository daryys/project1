package ru.example.project1.ui.folder_list

import androidx.lifecycle.MutableLiveData
import ru.example.project1.R
import ru.example.project1.core.ui.BaseViewModel
import ru.example.project1.ui.folder_list.adapter.FolderListItem

class FolderListViewModel : BaseViewModel<FolderListState>() {

    override val state = MutableLiveData(FolderListState())
    fun addFolder() {
        state.value?.let {
            val currentList = it.folderList.toMutableList()
            currentList.add(FolderListItem.FolderItem(R.drawable.shopping_cart, "Task"))
            state.value = FolderListState(currentList)
        }
    }
}
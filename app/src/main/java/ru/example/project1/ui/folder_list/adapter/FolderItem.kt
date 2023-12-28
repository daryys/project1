package ru.example.project1.ui.folder_list.adapter

import androidx.annotation.DrawableRes


sealed class FolderListItem {
    data class FolderItem(@DrawableRes val res: Int, val title: String) : FolderListItem()
    object AddItemList : FolderListItem()

}
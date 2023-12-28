package ru.example.project1.ui.folder_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.example.project1.databinding.AddFolderItemBinding
import ru.example.project1.databinding.FolderItemBinding
import ru.example.project1.ui.folder_list.adapter.FolderListAdapter.Companion.ITEM_VIEW_TYPE

class FolderListAdapter(
    private val onItemClick: () -> Unit,
    private val addItemClick: () -> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    companion object {
        const val ADD_BUTTON_VIEW_TYPE = 0
        const val ITEM_VIEW_TYPE = 1
    }

    private val itemList: MutableList<FolderListItem> = mutableListOf(FolderListItem.AddItemList)

    fun setupAdapter(list: List<FolderListItem>) {
        itemList.clear()
        itemList.addAll(list)
        itemList.add(FolderListItem.AddItemList)
        notifyDataSetChanged()
    }

    inner class FolderListViewHolder(private val binding: FolderItemBinding) :
        ViewHolder(binding.root) {
        fun bind(item: FolderListItem.FolderItem) = with(binding) {
            ivFolderIcon.setImageDrawable(ContextCompat.getDrawable(root.context, item.res))
            tvFolderTitle.text = item.title
            root.setOnClickListener {
                onItemClick()
            }
        }
    }

    inner class AddItemListViewHolder(private val binding: AddFolderItemBinding) :
        ViewHolder(binding.root) {
        fun bind() = with(binding) {
            root.setOnClickListener {
                addItemClick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        ITEM_VIEW_TYPE -> {
            FolderListViewHolder(
                FolderItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        else -> {
            AddItemListViewHolder(
                AddFolderItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }


    override fun getItemViewType(position: Int) = when (itemList[position]) {
        is FolderListItem.FolderItem -> ITEM_VIEW_TYPE
        is FolderListItem.AddItemList -> ADD_BUTTON_VIEW_TYPE
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder.itemViewType) {
            ITEM_VIEW_TYPE -> (holder as FolderListViewHolder).bind(itemList[position] as FolderListItem.FolderItem)
            ADD_BUTTON_VIEW_TYPE -> (holder as AddItemListViewHolder).bind()
        }
    }
}
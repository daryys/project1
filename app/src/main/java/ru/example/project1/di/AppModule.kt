package ru.example.project1.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.example.project1.ui.folder_list.FolderListViewModel
import ru.example.project1.ui.main.MainViewModel
import ru.example.project1.ui.search.SearchViewModel
import ru.example.project1.ui.task_list.TaskListViewModel

val appModule = module {
    viewModel {
        MainViewModel()
    }
    viewModel {
        SearchViewModel()
    }
    viewModel {
        FolderListViewModel()
    }
    viewModel {
        TaskListViewModel()
    }
}
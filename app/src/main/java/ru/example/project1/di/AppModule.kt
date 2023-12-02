package ru.example.project1.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.example.project1.ui.main.MainViewModel
import ru.example.project1.ui.search.SearchViewModel

val appModule = module {
    viewModel {
        MainViewModel()
    }
    viewModel {
        SearchViewModel()
    }
}
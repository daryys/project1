package ru.example.project1.ui.search

import androidx.lifecycle.MutableLiveData
import ru.example.project1.core.ui.BaseViewModel

class SearchViewModel : BaseViewModel<Unit>() {
    override val state = MutableLiveData(Unit)
}
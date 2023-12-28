package ru.example.project1.ui.main

import androidx.lifecycle.MutableLiveData
import ru.example.project1.core.ui.BaseViewModel

class MainViewModel : BaseViewModel<Unit>() {
    override val state = MutableLiveData(Unit)
}
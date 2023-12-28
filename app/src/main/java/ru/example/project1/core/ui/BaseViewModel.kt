package ru.example.project1.core.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T> : ViewModel() {

    abstract val state: MutableLiveData<T>
}
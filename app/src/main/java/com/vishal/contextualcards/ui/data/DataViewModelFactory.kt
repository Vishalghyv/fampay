package com.vishal.contextualcards.ui.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vishal.contextualcards.data.repositories.DataRepository

@Suppress("UNCHECKED_CAST")
class DataViewModelFactory(
    private val repository: DataRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DataViewModel(repository) as T
    }

}
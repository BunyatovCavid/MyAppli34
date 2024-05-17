package com.example.myappli.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.myappli.Interfaces.Costumer
import com.example.myappli.Repositories.CostumerRepository
import kotlinx.coroutines.launch

class CostumerViewModel(private val repository: CostumerRepository) : ViewModel() {

    // Using LiveData and caching what allWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allWords: LiveData<List<Costumer>> = repository.allWords.asLiveData()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(costumer: Costumer) = viewModelScope.launch {
        repository.insert(costumer)
    }
}

class CostumerViewModelFactory(private val repository: CostumerRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CostumerViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CostumerViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
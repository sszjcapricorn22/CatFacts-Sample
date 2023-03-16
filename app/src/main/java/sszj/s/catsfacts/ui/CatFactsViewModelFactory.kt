package sszj.s.catsfacts.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sszj.s.catsfacts.repository.CatFactsRepository

@Suppress("UNCHECKED_CAST")
class CatFactsViewModelFactory(private val repository: CatFactsRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CatFactsViewModel(repository) as T
    }
}
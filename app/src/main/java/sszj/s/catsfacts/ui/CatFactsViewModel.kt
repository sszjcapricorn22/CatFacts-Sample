package sszj.s.catsfacts.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sszj.s.catsfacts.model.CatFact
import sszj.s.catsfacts.repository.CatFactsRepository

class CatFactsViewModel(private val catFactRepository: CatFactsRepository) : ViewModel() {
    private val _catFacts = MutableLiveData<List<CatFact>>()
    val catFacts: LiveData<List<CatFact>> = _catFacts

    fun loadCatFacts() {
        viewModelScope.launch {
            try {
                val facts = catFactRepository.getCatFacts()
                _catFacts.value = facts
                Log.d("test123", "Cat facts in ViewModel: ${catFacts.value?.size}")
                Log.d("test123", "Cat facts in ViewModel: ${catFacts.value?.size}")
            } catch (e: Exception) {
                Log.d("test123", e.toString())
            }
        }
    }
}

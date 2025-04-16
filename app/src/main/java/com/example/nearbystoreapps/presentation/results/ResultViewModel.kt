package com.example.nearbystoreapps.presentation.results

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nearbystoreapps.domain.CategoryModelUi
import com.example.nearbystoreapps.domain.repository.ResultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val resultRepository: ResultRepository
) : ViewModel() {

    private val _subCategory = MutableLiveData<List<CategoryModelUi>>()
    val subCategory : LiveData<List<CategoryModelUi>> = _subCategory

    fun fetchSubCategory(id : String) {
        viewModelScope.launch {
            try {
                val res = resultRepository.loadSubCategory(id)
                _subCategory.value = res
            }catch (e : Exception){
                Log.d("TAG", "fetchSubCategory: ${e.message}")
            }
        }
    }
}
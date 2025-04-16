package com.example.nearbystoreapps.presentation.dashboard

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asFlow
import androidx.lifecycle.viewModelScope
import com.example.nearbystoreapps.domain.BannersModel
import com.example.nearbystoreapps.domain.CategoryModelUi
import com.example.nearbystoreapps.domain.repository.DashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val dashboardRepository: DashboardRepository
): ViewModel() {

    private val _categoryUi = MutableLiveData<List<CategoryModelUi>>()
    val category : LiveData<List<CategoryModelUi>> = _categoryUi

    private val _bannerUi = MutableLiveData<List<BannersModel>>()
    val banner  : LiveData<List<BannersModel>> = _bannerUi

    fun fetchCategory(){
        viewModelScope.launch {
         try {
             val result = dashboardRepository.loadCategory()
             _categoryUi.value = result
         }catch (e : Exception){
             Log.d(TAG, "fetchCategory: ${e.message}")
         }
        }
    }


    fun fetchBanners(){
        viewModelScope.launch {
            try {
                val result = dashboardRepository.loadBanners()
                _bannerUi.value = result
            }catch (e : Exception){
                Log.d(TAG, "fetchBanners: ${e.message}")
            }
        }
    }



}
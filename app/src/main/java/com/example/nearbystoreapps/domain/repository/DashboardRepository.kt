package com.example.nearbystoreapps.domain.repository

import com.example.nearbystoreapps.domain.BannersModel
import com.example.nearbystoreapps.domain.CategoryModelUi

interface DashboardRepository {

    suspend fun loadCategory(): List<CategoryModelUi>
    suspend fun loadBanners() : List<BannersModel>
}
package com.example.nearbystoreapps.domain.repository

import com.example.nearbystoreapps.domain.CategoryModelUi

interface ResultRepository {

    suspend fun loadSubCategory(id : String) : List<CategoryModelUi>

}
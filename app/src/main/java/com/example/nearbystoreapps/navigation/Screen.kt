package com.example.nearbystoreapps.navigation

import kotlinx.serialization.Serializable

@Serializable
data object Home

@Serializable
data object Support

@Serializable
data object WishList

@Serializable
data object Profile

@Serializable
data class Result(val categoryId : String)


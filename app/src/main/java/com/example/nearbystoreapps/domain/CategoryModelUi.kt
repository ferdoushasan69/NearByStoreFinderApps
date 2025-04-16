package com.example.nearbystoreapps.domain

import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.PropertyName


@IgnoreExtraProperties
data class CategoryModelUi(

    @get:PropertyName("ImagePath") @set:PropertyName("ImagePath")
    var imagePath: String = "",

    @get:PropertyName("Id") @set:PropertyName("Id")
    var id: Long = 0,

    @get:PropertyName("Name") @set:PropertyName("Name")
    var name: String = ""
)

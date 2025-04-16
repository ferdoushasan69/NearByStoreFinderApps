package com.example.nearbystoreapps.data.repository_impl

import com.example.nearbystoreapps.domain.CategoryModelUi
import com.example.nearbystoreapps.domain.repository.ResultRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject

class ResultRepositoryImpl @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase
): ResultRepository {

    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun loadSubCategory(id : String): List<CategoryModelUi> = suspendCancellableCoroutine{ continuation->
        val ref = firebaseDatabase.getReference("SubCategory")
        val query : Query = ref.orderByChild("CategoryId").equalTo(id)

        query.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list  = mutableListOf<CategoryModelUi>()
                for (childrenSnapShot in snapshot.children){
                    val items = childrenSnapShot.getValue(CategoryModelUi::class.java)
                    items?.let {
                        list.add(it)
                    }
                }
                continuation.resume(list,null)

            }

            override fun onCancelled(error: DatabaseError) {
                continuation.resumeWith(Result.failure(error.toException()))
            }
        })

    }
}
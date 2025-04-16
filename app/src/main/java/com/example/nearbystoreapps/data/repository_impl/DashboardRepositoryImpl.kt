package com.example.nearbystoreapps.data.repository_impl

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nearbystoreapps.domain.BannersModel
import com.example.nearbystoreapps.domain.CategoryModelUi
import com.example.nearbystoreapps.domain.repository.DashboardRepository
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject

class DashboardRepositoryImpl @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase
): DashboardRepository{
    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun loadCategory(): List<CategoryModelUi> = suspendCancellableCoroutine{ continuation->
        val listData = MutableLiveData<MutableList<CategoryModelUi>>()
        val ref = firebaseDatabase.getReference("Category")

        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<CategoryModelUi>()

                for (childSnapShot in snapshot.children){
                    val item = childSnapShot.getValue(CategoryModelUi::class.java)
                    item?.let {
                        list.add(it)
                    }
                }
                continuation.resume(list, null)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d(TAG, "onCancelled: ${error.message}")
                continuation.resumeWith(Result.failure(error.toException()))

            }

        })

    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun loadBanners(): List<BannersModel> = suspendCancellableCoroutine{ continuation->
        val ref = firebaseDatabase.getReference("Banners")
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val list = mutableListOf<BannersModel>()
                for (childSnapShot in snapshot.children){
                    val item = childSnapShot.getValue(BannersModel::class.java)
                    item?.let {
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
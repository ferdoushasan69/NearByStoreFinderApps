package com.example.nearbystoreapps.di

import com.example.nearbystoreapps.data.repository_impl.DashboardRepositoryImpl
import com.example.nearbystoreapps.data.repository_impl.ResultRepositoryImpl
import com.example.nearbystoreapps.domain.repository.DashboardRepository
import com.example.nearbystoreapps.domain.repository.ResultRepository
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseDataBase(): FirebaseDatabase = FirebaseDatabase.getInstance()

    @Provides
    @Singleton
    fun provideDashboardRepository(firebaseDatabase: FirebaseDatabase) : DashboardRepository = DashboardRepositoryImpl(firebaseDatabase)

    @Provides
    @Singleton
    fun provideResultRepository(firebaseDatabase: FirebaseDatabase) : ResultRepository =
        ResultRepositoryImpl(firebaseDatabase)
}
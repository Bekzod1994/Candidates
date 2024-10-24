package com.example.candidates.data.di

import com.example.candidates.data.local.LocalRepository
import com.example.candidates.data.local.entity.LocalRepositoryImpl
import com.example.candidates.data.repository.RepositoryImpl
import com.example.candidates.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    @Singleton
    fun bindRemoteRepository(repo: RepositoryImpl): Repository
    @Binds
    @Singleton
    fun bindLocalRepository(repo: LocalRepositoryImpl): LocalRepository
}
package com.example.candidates.data.di

import com.example.candidates.data.local.LocalRepositoryImpl
import com.example.candidates.data.repository.RemoteRepositoryImpl
import com.example.candidates.domain.repository.LocalRepository
import com.example.candidates.domain.repository.RemoteRepository
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
    fun bindRemoteRepository(repo: RemoteRepositoryImpl): RemoteRepository
    @Binds
    @Singleton
    fun bindLocalRepository(repo: LocalRepositoryImpl): LocalRepository
}
package com.example.candidates.data.local

import com.example.candidates.data.local.entity.CandidateEntity
import kotlinx.coroutines.flow.Flow

interface LocalRepository {

    suspend fun getAll(): Flow<List<CandidateEntity>>

    suspend fun getCandidate(id: Int): Flow<CandidateEntity>

    suspend fun saveAll(cards: List<CandidateEntity>)

    suspend fun deleteByIdList(cards: List<Int>)
}
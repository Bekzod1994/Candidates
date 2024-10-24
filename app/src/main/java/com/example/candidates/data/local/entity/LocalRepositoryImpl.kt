package com.example.candidates.data.local.entity

import com.example.candidates.data.local.LocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor() : LocalRepository {
    override suspend fun getAll(): Flow<List<CandidateEntity>> {
        return flowOf(
            listOf(
                CandidateEntity(
                    id = 1,
                    fullName = "Bekzod Qalandarov",
                    phone = "90991933",
                    age = "30",
                    salary = "3500",
                    stack = "Android"
                )
            )
        )
    }

    override suspend fun getCandidate(id: Int): Flow<CandidateEntity> {
        return flowOf(
            CandidateEntity(
                id = id,
                fullName = "Bekzod Qalandarov",
                phone = "90991933",
                age = "30",
                salary = "3500",
                stack = "Android"
            )
        )
    }

    override suspend fun saveAll(cards: List<CandidateEntity>) {

    }

    override suspend fun deleteByIdList(cards: List<Int>) {
    }
}
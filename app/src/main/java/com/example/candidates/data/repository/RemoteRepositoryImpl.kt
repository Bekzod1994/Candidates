package com.example.candidates.data.repository

import com.example.candidates.data.network.model.CandidateResponse
import com.example.candidates.data.network.model.ErrorResponse
import com.example.candidates.domain.repository.RemoteRepository
import com.haroldadmin.cnradapter.NetworkResponse
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    // private val service: CandidateService
) : RemoteRepository {
    override suspend fun getCandidates(): NetworkResponse<List<CandidateResponse>, ErrorResponse> {
        return NetworkResponse.Success(
            body = listOf(candidateResponse),
            response = retrofit2.Response.success(candidateResponse)
        )
    }
}

private val candidateResponse = CandidateResponse(
    id = 1,
    fistName = "Bekzod",
    lastName = "Qalandarov",
    phone = "90991933",
    age = "30",
    salary = "3500",
    stack = "Android"
)
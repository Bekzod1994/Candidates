package com.example.candidates.domain.repository

import com.example.candidates.data.network.model.CandidateResponse
import com.example.candidates.data.network.model.ErrorResponse
import com.haroldadmin.cnradapter.NetworkResponse

interface RemoteRepository {
    suspend fun getCandidates(): NetworkResponse<List<CandidateResponse>, ErrorResponse>
}
package com.example.candidates.data.repository

import com.example.candidates.data.network.model.CandidateResponse
import com.example.candidates.data.network.model.ErrorResponse
import com.example.candidates.data.network.service.CandidateService
import com.example.candidates.domain.repository.Repository
import com.haroldadmin.cnradapter.NetworkResponse
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    // private val service: CandidateService
) : Repository {
    override suspend fun getCandidates(): NetworkResponse<List<CandidateResponse>, ErrorResponse> {
        return NetworkResponse.Success(
            body = listOf(
                CandidateResponse(
                    id = 1,
                    fistName = "Bekzod",
                    lastName = "Qalandarov",
                    phone = "90991933",
                    age = "30",
                    salary = "3500",
                    stack = "Android"
                )
            ), response = retrofit2.Response.success("success")
        )
    }
}
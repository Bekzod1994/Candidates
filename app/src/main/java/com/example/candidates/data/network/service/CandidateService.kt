package com.example.candidates.data.network.service

import com.example.candidates.data.network.model.CandidateResponse
import com.example.candidates.data.network.model.ErrorResponse
import com.haroldadmin.cnradapter.NetworkResponse
import retrofit2.http.GET

interface CandidateService {
    @GET("candidates")
    fun getCandidates(): NetworkResponse<List<CandidateResponse>, ErrorResponse>
}
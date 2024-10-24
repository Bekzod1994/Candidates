package com.example.candidates.data.local.entity

import com.example.candidates.data.network.model.CandidateResponse

data class CandidateEntity(
    val id: Int,
    val fullName: String,
    val phone: String,
    val age: String,
    val salary: String,
    val stack: String
)

    fun CandidateResponse.toEntity(): CandidateEntity {
    return CandidateEntity(id, "$lastName $fistName", phone, age, salary, stack)
}
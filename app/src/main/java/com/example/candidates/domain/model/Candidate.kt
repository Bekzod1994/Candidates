package com.example.candidates.domain.model

import com.example.candidates.data.local.entity.CandidateEntity

data class Candidate(
    val id: Int,
    val fullName: String,
    val phone: String,
    val age: String,
    val salary: String,
    val stack: String
)

fun CandidateEntity.toDomain(): Candidate {
    return Candidate(id, fullName, phone, age, salary, stack)
}
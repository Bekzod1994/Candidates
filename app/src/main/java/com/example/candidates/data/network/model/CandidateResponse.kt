package com.example.candidates.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CandidateResponse(
    @SerialName("id") val id: Int,
    @SerialName("fistName") val fistName: String,
    @SerialName("lastName") val lastName: String,
    @SerialName("phone") val phone: String,
    @SerialName("age") val age: String,
    @SerialName("salary") val salary: String,
    @SerialName("stack") val stack: String
)
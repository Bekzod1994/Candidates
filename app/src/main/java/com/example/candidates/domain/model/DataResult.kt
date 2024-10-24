package com.example.candidates.domain.model
sealed class DataResult<S, E> {
    data class Success<S, E>(
        val data: S
    ) : DataResult<S, E>()

    data class Error<S, E>(
        val data: E
    ) : DataResult<S, E>()
}
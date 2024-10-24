package com.example.candidates.domain.usecases

import com.example.candidates.domain.model.Candidate
import com.example.candidates.domain.model.toDomain
import com.example.candidates.domain.repository.LocalRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import uz.core.utils.dispatchers.DispatchersProvider
import javax.inject.Inject

@ViewModelScoped
class GetCandidateUseCase @Inject constructor(
    private val repository: LocalRepository,
    private val dispatcher: DispatchersProvider,
) {
    suspend operator fun invoke(id: Int): Flow<Candidate> {
        return withContext(dispatcher.io) {
            repository.getCandidate(id).map { it.toDomain() }
        }
    }
}


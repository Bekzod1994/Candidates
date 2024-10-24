package com.example.candidates.domain.usecases

import com.example.candidates.data.local.LocalRepository
import com.example.candidates.data.local.entity.CandidateEntity
import com.example.candidates.data.local.entity.toEntity
import com.example.candidates.data.network.model.CandidateResponse
import com.example.candidates.domain.model.DataResult
import com.example.candidates.domain.repository.Repository
import com.haroldadmin.cnradapter.NetworkResponse
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.withContext
import uz.core.utils.dispatchers.DispatchersProvider
import javax.inject.Inject

@ViewModelScoped
class SyncCandidatesUseCase @Inject constructor(
    private val repository: Repository,
    private val localRepository: LocalRepository,
    private val dispatcher: DispatchersProvider
) {
    suspend operator fun invoke(): DataResult<Unit, String> {
        return withContext(dispatcher.io) {
            when (val result = repository.getCandidates()) {
                is NetworkResponse.Success -> {
                    localRepository.saveAll(result.body.map { it.toEntity() })
                    DataResult.Success(Unit)
                }

                is NetworkResponse.ServerError -> {
                    DataResult.Error(result.body?.message ?: "The response is invalid")
                }

                is NetworkResponse.NetworkError -> {
                    DataResult.Error("Network error")
                }

                is NetworkResponse.UnknownError -> {
                    DataResult.Error("The response is invalid")
                }
            }
        }
    }
}


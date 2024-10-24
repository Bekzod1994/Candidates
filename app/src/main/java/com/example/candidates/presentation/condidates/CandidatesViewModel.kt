package com.example.candidates.presentation.condidates

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.candidates.domain.model.Candidate
import com.example.candidates.domain.model.DataResult
import com.example.candidates.domain.usecases.GetCandidatesUseCase
import com.example.candidates.domain.usecases.SyncCandidatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CandidatesUIState(
    val list: List<Candidate> = listOf(),
    val errorMessage: String = "",
    val isLoading: Boolean = false
)

@HiltViewModel
class CandidatesViewModel @Inject constructor(
    private val candidatesUseCase: GetCandidatesUseCase,
    private val syncCandidatesUseCase: SyncCandidatesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CandidatesUIState())
    val uiState = _uiState.asStateFlow()

    init {
        sync()
        getCandidates()
    }

    private fun sync() {
        viewModelScope.launch {
            when (val result = syncCandidatesUseCase()) {
                is DataResult.Error -> _uiState.update { it.copy(errorMessage = result.data) }
                is DataResult.Success -> {}
            }
        }
    }

    private fun getCandidates() {
        viewModelScope.launch {
            candidatesUseCase()
                .catch { e -> _uiState.update { it.copy(errorMessage = e.message ?: "") } }
                .collectLatest { list ->
                    _uiState.update { it.copy(list = list) }
                }
        }

    }


}
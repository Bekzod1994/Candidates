package com.example.candidates.presentation.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.candidates.domain.model.Candidate
import com.example.candidates.domain.usecases.GetCandidateUseCase
import com.example.candidates.presentation.CandidateDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CandidateUIState(
    val candidate: Candidate? = null,
    val errorMessage: String = "",
    val isLoading: Boolean = false
)

@HiltViewModel
class CandidateDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val candidateUseCase: GetCandidateUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(CandidateUIState())
    val uiState = _uiState.asStateFlow()
    private val candidate = savedStateHandle.toRoute<CandidateDetails>()

    init {
        getCandidate()
    }

    private fun getCandidate() {
        viewModelScope.launch {
            candidateUseCase(id = candidate.id)
                .catch { e -> _uiState.update { it.copy(errorMessage = e.message ?: "") } }
                .collectLatest { candidate ->
                    _uiState.update { it.copy(candidate = candidate) }
                }
        }
    }
}
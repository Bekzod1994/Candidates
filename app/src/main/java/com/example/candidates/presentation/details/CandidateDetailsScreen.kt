package com.example.candidates.presentation.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CandidateDetailsScreen(viewModel: CandidateDetailsViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text(text = "Candidate Details") }) })
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
        ) {
            uiState.candidate?.let {
                Text(text = it.id.toString())
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = it.fullName)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = it.age)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = it.salary)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = it.phone)
            }
        }
    }
}
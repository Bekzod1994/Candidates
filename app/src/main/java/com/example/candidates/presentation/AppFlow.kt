package com.example.candidates.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.candidates.presentation.condidates.CandidatesScreen
import com.example.candidates.presentation.details.CandidateDetailsScreen
import kotlinx.serialization.Serializable

@Serializable
internal object Candidates

@Serializable
internal data class CandidateDetails(val id: Int)

@Composable
fun AppFlow() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Candidates
    ) {
        composable<Candidates> {
            CandidatesScreen(onClickItem = { id ->
                navController.navigate(CandidateDetails(id))
            })
        }
        composable<CandidateDetails> {
            CandidateDetailsScreen()
        }
    }
}
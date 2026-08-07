package com.example.cp3406_a3_edu_app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cp3406_a3_edu_app.data.AppContainer

class AstronomyViewModelFactory(
    private val container: AppContainer
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AstronomyViewModel::class.java)) {
            return AstronomyViewModel(
                repository = container.astronomyRepository,
                apodRepository = container.apodRepository,
                quizAttemptRepository = container.quizAttemptRepository,
                userPreferencesRepository = container.userPreferencesRepository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

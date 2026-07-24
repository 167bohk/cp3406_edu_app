package com.example.cp3406_a3_edu_app.ui

import androidx.lifecycle.ViewModel
import com.example.cp3406_a3_edu_app.data.AstronomyRepository
import com.example.cp3406_a3_edu_app.data.DemoAstronomyRepository
import com.example.cp3406_a3_edu_app.data.LearningStats
import com.example.cp3406_a3_edu_app.data.QuizScorer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class AstronomyUiState(
    val questionIndex: Int = 0,
    val selectedAnswer: Int? = null,
    val answerSubmitted: Boolean = false,
    val stats: LearningStats = LearningStats(),
    val soundEnabled: Boolean = true,
    val difficulty: String = "Medium"
)

class AstronomyViewModel(
    private val repository: AstronomyRepository = DemoAstronomyRepository()
) : ViewModel() {
    val questions = repository.questions()

    private val _uiState = MutableStateFlow(AstronomyUiState())
    val uiState: StateFlow<AstronomyUiState> = _uiState.asStateFlow()

    fun selectAnswer(index: Int) {
        if (!_uiState.value.answerSubmitted) {
            _uiState.update { it.copy(selectedAnswer = index) }
        }
    }

    fun submitAnswer() {
        val state = _uiState.value
        val selected = state.selectedAnswer ?: return
        if (state.answerSubmitted) return
        val correct = QuizScorer.isCorrect(questions[state.questionIndex], selected)
        _uiState.update {
            it.copy(
                answerSubmitted = true,
                stats = it.stats.copy(
                    correctAnswers = it.stats.correctAnswers + if (correct) 1 else 0,
                    totalAnswers = it.stats.totalAnswers + 1
                )
            )
        }
    }

    fun nextQuestion() {
        val isLast = _uiState.value.questionIndex == questions.lastIndex
        _uiState.update {
            it.copy(
                questionIndex = if (isLast) 0 else it.questionIndex + 1,
                selectedAnswer = null,
                answerSubmitted = false,
                stats = if (isLast) {
                    it.stats.copy(
                        completedQuizzes = it.stats.completedQuizzes + 1,
                        currentStreak = it.stats.currentStreak + 1
                    )
                } else it.stats
            )
        }
    }

    fun setSound(enabled: Boolean) = _uiState.update { it.copy(soundEnabled = enabled) }
    fun setDifficulty(value: String) = _uiState.update { it.copy(difficulty = value) }
}

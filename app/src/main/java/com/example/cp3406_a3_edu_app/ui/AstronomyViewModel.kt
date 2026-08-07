package com.example.cp3406_a3_edu_app.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cp3406_a3_edu_app.data.ApodRepository
import com.example.cp3406_a3_edu_app.data.AstronomyRepository
import com.example.cp3406_a3_edu_app.data.LearningStats
import com.example.cp3406_a3_edu_app.data.QuizAttemptRepository
import com.example.cp3406_a3_edu_app.data.QuizScorer
import com.example.cp3406_a3_edu_app.data.QuestionSelector
import com.example.cp3406_a3_edu_app.data.SpaceQuestion
import com.example.cp3406_a3_edu_app.data.UserPreferencesRepository
import com.example.cp3406_a3_edu_app.data.local.QuizAttempt
import com.example.cp3406_a3_edu_app.data.network.ApodPhoto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface ApodUiState {
    data object Loading : ApodUiState
    data class Success(val photo: ApodPhoto) : ApodUiState
    data object Error : ApodUiState
}

data class AstronomyUiState(
    val questionIndex: Int = 0,
    val selectedAnswer: Int? = null,
    val answerSubmitted: Boolean = false,
    val stats: LearningStats = LearningStats(),
    val recentAttempts: List<QuizAttempt> = emptyList(),
    val soundEnabled: Boolean = true,
    val difficulty: String = "Medium"
)

class AstronomyViewModel(
    private val repository: AstronomyRepository,
    private val apodRepository: ApodRepository,
    private val quizAttemptRepository: QuizAttemptRepository,
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {
    private val allQuestions = repository.questions()

    var questions: List<SpaceQuestion> by mutableStateOf(
        QuestionSelector.select(allQuestions, difficulty = "Medium")
    )
        private set

    val learningTopics = repository.learningTopics()
    val planets = repository.planets()

    var apodUiState: ApodUiState by mutableStateOf(ApodUiState.Loading)
        private set

    private val _uiState = MutableStateFlow(AstronomyUiState())
    val uiState: StateFlow<AstronomyUiState> = _uiState.asStateFlow()

    init {
        loadAstronomyPicture()
        observeQuizHistory()
        observeUserPreferences()
    }

    private fun observeUserPreferences() {
        viewModelScope.launch {
            userPreferencesRepository.preferences.collect { preferences ->
                val difficultyChanged =
                    preferences.difficulty != _uiState.value.difficulty

                if (difficultyChanged) {
                    questions = QuestionSelector.select(
                        questions = allQuestions,
                        difficulty = preferences.difficulty
                    )
                }

                _uiState.update { currentState ->
                    currentState.copy(
                        questionIndex = if (difficultyChanged) 0 else currentState.questionIndex,
                        selectedAnswer = if (difficultyChanged) null else currentState.selectedAnswer,
                        answerSubmitted = if (difficultyChanged) false else currentState.answerSubmitted,
                        soundEnabled = preferences.soundEnabled,
                        difficulty = preferences.difficulty
                    )
                }
            }
        }
    }

    private fun observeQuizHistory() {
        viewModelScope.launch {
            quizAttemptRepository.getStatsStream().collect { stats ->
                _uiState.update { it.copy(stats = stats) }
            }
        }

        viewModelScope.launch {
            quizAttemptRepository.getRecentAttemptsStream().collect { attempts ->
                _uiState.update { it.copy(recentAttempts = attempts) }
            }
        }
    }

    fun loadAstronomyPicture() {
        apodUiState = ApodUiState.Loading
        viewModelScope.launch {
            apodUiState = try {
                ApodUiState.Success(apodRepository.getTodayPicture())
            } catch (exception: Exception) {
                ApodUiState.Error
            }
        }
    }

    fun selectAnswer(index: Int) {
        if (!_uiState.value.answerSubmitted) {
            _uiState.update { it.copy(selectedAnswer = index) }
        }
    }

    fun submitAnswer() {
        val state = _uiState.value
        val selected = state.selectedAnswer ?: return
        if (state.answerSubmitted) return
        val question = questions[state.questionIndex]
        val correct = QuizScorer.isCorrect(question, selected)

        _uiState.update {
            it.copy(answerSubmitted = true)
        }

        viewModelScope.launch {
            quizAttemptRepository.insertAttempt(
                QuizAttempt(
                    questionId = question.id,
                    questionText = question.prompt,
                    isCorrect = correct,
                    completedQuiz = state.questionIndex == questions.lastIndex,
                    answeredAt = System.currentTimeMillis()
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
                answerSubmitted = false
            )
        }
    }

    fun setSound(enabled: Boolean) {
        viewModelScope.launch {
            userPreferencesRepository.saveSoundEnabled(enabled)
        }
    }

    fun setDifficulty(value: String) {
        viewModelScope.launch {
            userPreferencesRepository.saveDifficulty(value)
        }
    }
}

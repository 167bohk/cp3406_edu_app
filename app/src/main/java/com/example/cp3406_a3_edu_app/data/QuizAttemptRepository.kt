package com.example.cp3406_a3_edu_app.data

import com.example.cp3406_a3_edu_app.data.local.QuizAttempt
import com.example.cp3406_a3_edu_app.data.local.QuizAttemptDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface QuizAttemptRepository {
    fun getStatsStream(): Flow<LearningStats>
    fun getRecentAttemptsStream(): Flow<List<QuizAttempt>>
    suspend fun insertAttempt(attempt: QuizAttempt)
}

class OfflineQuizAttemptRepository(
    private val quizAttemptDao: QuizAttemptDao
) : QuizAttemptRepository {
    override fun getStatsStream(): Flow<LearningStats> {
        return quizAttemptDao.getStats().map { storedStats ->
            LearningStats(
                completedQuizzes = storedStats.completedQuizzes,
                correctAnswers = storedStats.correctAnswers,
                totalAnswers = storedStats.totalAnswers
            )
        }
    }

    override fun getRecentAttemptsStream(): Flow<List<QuizAttempt>> {
        return quizAttemptDao.getRecentAttempts()
    }

    override suspend fun insertAttempt(attempt: QuizAttempt) {
        quizAttemptDao.insert(attempt)
    }
}

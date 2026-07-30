package com.example.cp3406_a3_edu_app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizAttemptDao {
    @Insert
    suspend fun insert(attempt: QuizAttempt)

    @Query(
        """
        SELECT
            COUNT(*) AS totalAnswers,
            COALESCE(SUM(CASE WHEN isCorrect = 1 THEN 1 ELSE 0 END), 0)
                AS correctAnswers,
            COALESCE(SUM(CASE WHEN completedQuiz = 1 THEN 1 ELSE 0 END), 0)
                AS completedQuizzes
        FROM quiz_attempt
        """
    )
    fun getStats(): Flow<StoredQuizStats>

    @Query(
        """
        SELECT * FROM quiz_attempt
        ORDER BY answeredAt DESC
        LIMIT 10
        """
    )
    fun getRecentAttempts(): Flow<List<QuizAttempt>>
}

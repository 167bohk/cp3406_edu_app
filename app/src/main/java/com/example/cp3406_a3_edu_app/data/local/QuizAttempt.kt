package com.example.cp3406_a3_edu_app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quiz_attempt")
data class QuizAttempt(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val questionId: Int,
    val questionText: String,
    val isCorrect: Boolean,
    val completedQuiz: Boolean,
    val answeredAt: Long
)

data class StoredQuizStats(
    val totalAnswers: Int,
    val correctAnswers: Int,
    val completedQuizzes: Int
)

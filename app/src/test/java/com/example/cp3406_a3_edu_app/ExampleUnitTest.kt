package com.example.cp3406_a3_edu_app

import com.example.cp3406_a3_edu_app.data.QuizScorer
import com.example.cp3406_a3_edu_app.data.SpaceQuestion
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun quizScorer_recognisesCorrectAndIncorrectAnswers() {
        val question = SpaceQuestion(
            id = 1,
            prompt = "Test",
            answers = listOf("Wrong", "Correct"),
            correctAnswerIndex = 1,
            explanation = "Test explanation"
        )

        assertTrue(QuizScorer.isCorrect(question, 1))
        assertFalse(QuizScorer.isCorrect(question, 0))
    }
}

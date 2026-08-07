package com.example.cp3406_a3_edu_app

import com.example.cp3406_a3_edu_app.data.QuizScorer
import com.example.cp3406_a3_edu_app.data.QuizAnswerResult
import com.example.cp3406_a3_edu_app.data.QuizResultCalculator
import com.example.cp3406_a3_edu_app.data.QuestionSelector
import com.example.cp3406_a3_edu_app.data.QuestionBank
import com.example.cp3406_a3_edu_app.data.LearningContent
import com.example.cp3406_a3_edu_app.data.PlanetCatalog
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

    @Test
    fun quizResultCalculator_returnsScoreAndAccuracy() {
        val question = SpaceQuestion(
            id = 1,
            prompt = "Test",
            answers = listOf("Wrong", "Correct"),
            correctAnswerIndex = 1,
            explanation = "Test explanation"
        )
        val answers = listOf(
            QuizAnswerResult(question, selectedAnswerIndex = 1),
            QuizAnswerResult(question.copy(id = 2), selectedAnswerIndex = 0),
            QuizAnswerResult(question.copy(id = 3), selectedAnswerIndex = 1)
        )

        assertEquals(2, QuizResultCalculator.score(answers))
        assertEquals(66, QuizResultCalculator.accuracy(answers))
        assertEquals(1, answers.count { !it.isCorrect })
    }

    @Test
    fun questionBank_hasValidQuestions() {
        val questions = QuestionBank.questions

        assertEquals(60, questions.size)
        assertEquals(questions.size, questions.map { it.id }.distinct().size)

        questions.forEach { question ->
            assertEquals(4, question.answers.size)
            assertTrue(question.correctAnswerIndex in question.answers.indices)
            assertTrue(question.sourceUrl.startsWith("https://science.nasa.gov/"))
            assertTrue(question.difficulty in listOf("Easy", "Medium", "Hard"))
        }
    }

    @Test
    fun questionSelector_usesTheSelectedDifficulty() {
        listOf("Easy", "Medium", "Hard").forEach { difficulty ->
            val selectedQuestions = QuestionSelector.select(
                questions = QuestionBank.questions,
                difficulty = difficulty
            )

            assertEquals(5, selectedQuestions.size)
            assertTrue(selectedQuestions.all { it.difficulty == difficulty })
        }
    }

    @Test
    fun learningContent_hasFactsAndSources() {
        assertEquals(11, LearningContent.topics.size)

        LearningContent.topics.forEach { topic ->
            assertTrue(topic.facts.isNotEmpty())
            assertTrue(topic.sourceUrl.startsWith("https://science.nasa.gov/"))
        }
    }

    @Test
    fun learningMaterials_coverEveryQuizQuestion() {
        val quizQuestionIds = QuestionBank.questions.map { it.id }.toSet()
        val lessonQuestionIds = LearningContent.topics.flatMap { it.questionIds }
        val planetQuestionIds = PlanetCatalog.planets.flatMap { it.questionIds }
        val coveredQuestionIds = lessonQuestionIds + planetQuestionIds

        assertEquals(quizQuestionIds, coveredQuestionIds.toSet())
        assertEquals(coveredQuestionIds.size, coveredQuestionIds.distinct().size)
    }

    @Test
    fun planetCatalog_containsEightValidPlanets() {
        val planets = PlanetCatalog.planets

        assertEquals(8, planets.size)
        assertEquals((1..8).toList(), planets.map { it.orderFromSun })
        assertEquals(22, planets.flatMap { it.questionIds }.size)

        planets.forEach { planet ->
            assertTrue(planet.funFacts.isNotEmpty())
            assertTrue(planet.orbitSpeed > 0)
            assertTrue(planet.sourceUrl.startsWith("https://science.nasa.gov/"))
        }
    }
}

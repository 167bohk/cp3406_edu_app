package com.example.cp3406_a3_edu_app

import com.example.cp3406_a3_edu_app.data.QuizScorer
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
    fun questionBank_hasValidQuestions() {
        val questions = QuestionBank.questions

        assertEquals(44, questions.size)
        assertEquals(questions.size, questions.map { it.id }.distinct().size)

        questions.forEach { question ->
            assertEquals(4, question.answers.size)
            assertTrue(question.correctAnswerIndex in question.answers.indices)
            assertTrue(question.sourceUrl.startsWith("https://science.nasa.gov/"))
        }
    }

    @Test
    fun learningContent_hasFactsAndSources() {
        assertEquals(9, LearningContent.topics.size)

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

        planets.forEach { planet ->
            assertTrue(planet.funFacts.isNotEmpty())
            assertTrue(planet.orbitSpeed > 0)
            assertTrue(planet.sourceUrl.startsWith("https://science.nasa.gov/"))
        }
    }
}

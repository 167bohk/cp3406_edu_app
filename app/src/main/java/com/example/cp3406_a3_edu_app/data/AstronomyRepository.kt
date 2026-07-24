package com.example.cp3406_a3_edu_app.data

data class SpaceQuestion(
    val id: Int,
    val prompt: String,
    val answers: List<String>,
    val correctAnswerIndex: Int,
    val explanation: String
)

data class LearningStats(
    val completedQuizzes: Int = 0,
    val correctAnswers: Int = 0,
    val totalAnswers: Int = 0,
    val currentStreak: Int = 0
) {
    val accuracy: Int
        get() = if (totalAnswers == 0) 0 else correctAnswers * 100 / totalAnswers
}

interface AstronomyRepository {
    fun questions(): List<SpaceQuestion>
}

/**
 * Offline starter data. A later Room + network repository can implement the same
 * interface without changing the screens or ViewModel contract.
 */
class DemoAstronomyRepository : AstronomyRepository {
    override fun questions() = listOf(
        SpaceQuestion(
            id = 1,
            prompt = "Which planet is known as the Red Planet?",
            answers = listOf("Venus", "Mars", "Jupiter", "Mercury"),
            correctAnswerIndex = 1,
            explanation = "Iron minerals in the Martian soil oxidise, giving Mars its red colour."
        ),
        SpaceQuestion(
            id = 2,
            prompt = "What is the name of our galaxy?",
            answers = listOf("Andromeda", "Whirlpool", "Milky Way", "Sombrero"),
            correctAnswerIndex = 2,
            explanation = "The Solar System is located in the Milky Way galaxy."
        ),
        SpaceQuestion(
            id = 3,
            prompt = "Which object has the strongest gravity?",
            answers = listOf("Moon", "Comet", "Asteroid", "Black hole"),
            correctAnswerIndex = 3,
            explanation = "A black hole concentrates enormous mass into a very small region."
        )
    )
}

object QuizScorer {
    fun isCorrect(question: SpaceQuestion, selectedIndex: Int): Boolean =
        selectedIndex == question.correctAnswerIndex
}

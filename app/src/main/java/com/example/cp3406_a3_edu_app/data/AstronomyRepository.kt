package com.example.cp3406_a3_edu_app.data

data class SpaceQuestion(
    val id: Int,
    val prompt: String,
    val answers: List<String>,
    val correctAnswerIndex: Int,
    val explanation: String,
    val topic: String = "General",
    val sourceUrl: String = "",
    val difficulty: String = "Medium"
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
    fun learningTopics(): List<LearningTopic>
    fun planets(): List<PlanetInfo>
}

class DemoAstronomyRepository : AstronomyRepository {
    override fun questions() = QuestionBank.questions
    override fun learningTopics() = LearningContent.topics
    override fun planets() = PlanetCatalog.planets
}

object QuizScorer {
    fun isCorrect(question: SpaceQuestion, selectedIndex: Int): Boolean =
        selectedIndex == question.correctAnswerIndex
}

data class QuizAnswerResult(
    val question: SpaceQuestion,
    val selectedAnswerIndex: Int
) {
    val isCorrect: Boolean
        get() = selectedAnswerIndex == question.correctAnswerIndex
}

object QuizResultCalculator {
    fun score(answers: List<QuizAnswerResult>): Int =
        answers.count { it.isCorrect }

    fun accuracy(answers: List<QuizAnswerResult>): Int =
        if (answers.isEmpty()) 0 else score(answers) * 100 / answers.size
}

object QuestionSelector {
    fun select(
        questions: List<SpaceQuestion>,
        difficulty: String,
        count: Int = 5
    ): List<SpaceQuestion> {
        val matchingQuestions = questions.filter { it.difficulty == difficulty }
        return matchingQuestions.shuffled().take(count)
    }
}

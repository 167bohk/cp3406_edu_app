package com.example.cp3406_a3_edu_app

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToNode
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun bottomNavigation_opensMainScreens() {
        composeTestRule.onNodeWithTag("home_screen").assertIsDisplayed()

        composeTestRule.onNodeWithTag("nav_learn").performClick()
        composeTestRule.onNodeWithTag("learning_screen").assertIsDisplayed()

        composeTestRule.onNodeWithTag("nav_quiz").performClick()
        composeTestRule.onNodeWithTag("quiz_screen").assertIsDisplayed()

        composeTestRule.onNodeWithTag("nav_stats").performClick()
        composeTestRule.onNodeWithTag("stats_screen").assertIsDisplayed()

        composeTestRule.onNodeWithTag("nav_settings").performClick()
        composeTestRule.onNodeWithTag("settings_screen").assertIsDisplayed()
    }

    @Test
    fun learningScreen_containsNewAstronomyTopic() {
        composeTestRule.onNodeWithTag("nav_learn").performClick()

        composeTestRule
            .onNodeWithTag("learning_screen")
            .performScrollToNode(hasText("Star Life Cycles"))

        composeTestRule.onNodeWithText("Star Life Cycles").assertIsDisplayed()
    }

    @Test
    fun solarSystemModel_containsPlanetLearningContent() {
        composeTestRule.onNodeWithTag("nav_learn").performClick()
        composeTestRule.onNodeWithText("Explore the Model").performClick()

        composeTestRule.onNodeWithTag("solar_system_screen").assertIsDisplayed()
        composeTestRule.onNodeWithText("Planet groups").assertIsDisplayed()
        composeTestRule
            .onNodeWithText("Rocky planets: Mercury, Venus, Earth and Mars.")
            .assertIsDisplayed()
    }

    @Test
    fun settings_canSelectHardDifficulty() {
        composeTestRule.onNodeWithTag("nav_settings").performClick()
        composeTestRule.onNodeWithTag("difficulty_hard").performClick()
        composeTestRule.waitUntil(timeoutMillis = 5_000) {
            composeTestRule
                .onNodeWithTag("difficulty_hard")
                .fetchSemanticsNode()
                .config[SemanticsProperties.Selected]
        }

        composeTestRule.onNodeWithTag("difficulty_hard").assertIsSelected()
    }

    @Test
    fun quiz_canSubmitAnswerAndMoveToNextQuestion() {
        composeTestRule.onNodeWithTag("nav_quiz").performClick()
        composeTestRule.onNodeWithText("Question 1 of 5").assertIsDisplayed()

        composeTestRule.onNodeWithTag("answer_0").performClick()
        composeTestRule.onNodeWithTag("quiz_action").performClick()
        composeTestRule.onNodeWithText("Next Question").assertIsDisplayed()

        composeTestRule.onNodeWithTag("quiz_action").performClick()
        composeTestRule.onNodeWithText("Question 2 of 5").assertIsDisplayed()
    }

    @Test
    fun quiz_showsResultAndCanStartAgain() {
        composeTestRule.onNodeWithTag("nav_quiz").performClick()

        repeat(5) { questionIndex ->
            composeTestRule.onNodeWithTag("answer_0").performClick()
            composeTestRule.onNodeWithTag("quiz_action").performClick()

            if (questionIndex < 4) {
                composeTestRule.onNodeWithText("Next Question").performClick()
            } else {
                composeTestRule.onNodeWithText("View Results").performClick()
            }
        }

        composeTestRule.onNodeWithTag("quiz_result_screen").assertIsDisplayed()
        composeTestRule.onNodeWithText("Quiz Complete!").assertIsDisplayed()
        composeTestRule.onNodeWithText("Accuracy:", substring = true).assertIsDisplayed()
        composeTestRule.onNodeWithText("Difficulty:", substring = true).assertIsDisplayed()

        composeTestRule
            .onNodeWithTag("quiz_result_screen")
            .performScrollToNode(hasText("Try Again"))
        composeTestRule.onNodeWithTag("quiz_try_again").assertIsDisplayed()
        composeTestRule
            .onNodeWithTag("quiz_result_screen")
            .performScrollToNode(hasText("Review Lessons"))
        composeTestRule.onNodeWithText("Review Lessons").assertIsDisplayed()
        composeTestRule
            .onNodeWithTag("quiz_result_screen")
            .performScrollToNode(hasText("View Statistics"))
        composeTestRule.onNodeWithText("View Statistics").assertIsDisplayed()
        composeTestRule
            .onNodeWithTag("quiz_result_screen")
            .performScrollToNode(hasText("Try Again"))
        composeTestRule.onNodeWithTag("quiz_try_again").performClick()

        composeTestRule.onNodeWithText("Question 1 of 5").assertIsDisplayed()
    }
}

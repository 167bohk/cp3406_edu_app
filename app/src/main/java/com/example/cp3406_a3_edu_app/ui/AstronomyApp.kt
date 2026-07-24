package com.example.cp3406_a3_edu_app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cp3406_a3_edu_app.data.LearningStats

private data class NavItem(
    val route: String,
    val title: String
)

private val navItems = listOf(
    NavItem("home", "Home"),
    NavItem("quiz", "Quiz"),
    NavItem("stats", "Stats"),
    NavItem("settings", "Settings")
)

@Composable
fun AstronomyApp(viewModel: AstronomyViewModel) {
    val navController = rememberNavController()
    val uiState by viewModel.uiState.collectAsState()
    val currentEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {
                navItems.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo("home")
                                launchSingleTop = true
                            }
                        },
                        icon = { Text(item.title.first().toString()) },
                        label = { Text(item.title) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen(
                    stats = uiState.stats,
                    onStartQuiz = { navController.navigate("quiz") }
                )
            }

            composable("quiz") {
                QuizScreen(
                    viewModel = viewModel,
                    uiState = uiState
                )
            }

            composable("stats") {
                StatsScreen(stats = uiState.stats)
            }

            composable("settings") {
                SettingsScreen(
                    uiState = uiState,
                    onSoundChanged = viewModel::setSound,
                    onDifficultyChanged = viewModel::setDifficulty
                )
            }
        }
    }
}

@Composable
private fun HomeScreen(
    stats: LearningStats,
    onStartQuiz: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Stellar Academy",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text("Learn basic astronomy through short quizzes.")
        }

        item {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Solar System Quiz",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text("Answer three questions about planets and space.")
                    Button(
                        onClick = onStartQuiz,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Start Quiz")
                    }
                }
            }
        }

        item {
            Text(
                text = "Current Progress",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text("Accuracy: ${stats.accuracy}%")
            Text("Completed quizzes: ${stats.completedQuizzes}")
        }

        item {
            Text(
                text = "Future Topics",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text("• The Solar System")
            Text("• Stars and galaxies")
            Text("• Space exploration")
        }
    }
}

@Composable
private fun QuizScreen(
    viewModel: AstronomyViewModel,
    uiState: AstronomyUiState
) {
    val question = viewModel.questions[uiState.questionIndex]

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "Question ${uiState.questionIndex + 1} of ${viewModel.questions.size}",
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = question.prompt,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }

        itemsIndexed(question.answers) { index, answer ->
            OutlinedButton(
                onClick = { viewModel.selectAnswer(index) },
                enabled = !uiState.answerSubmitted,
                modifier = Modifier.fillMaxWidth()
            ) {
                val selectedText =
                    if (uiState.selectedAnswer == index) "Selected: " else ""
                Text("$selectedText$answer")
            }
        }

        if (uiState.answerSubmitted) {
            item {
                val isCorrect =
                    uiState.selectedAnswer == question.correctAnswerIndex

                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = if (isCorrect) "Correct!" else "Incorrect",
                            fontWeight = FontWeight.Bold
                        )
                        Text(question.explanation)
                    }
                }
            }
        }

        item {
            Button(
                onClick = {
                    if (uiState.answerSubmitted) {
                        viewModel.nextQuestion()
                    } else {
                        viewModel.submitAnswer()
                    }
                },
                enabled = uiState.selectedAnswer != null,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    if (uiState.answerSubmitted) "Next Question"
                    else "Submit Answer"
                )
            }
        }
    }
}

@Composable
private fun StatsScreen(stats: LearningStats) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Learning Statistics",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        StatItem("Completed quizzes", stats.completedQuizzes.toString())
        StatItem("Correct answers", stats.correctAnswers.toString())
        StatItem("Total answers", stats.totalAnswers.toString())
        StatItem("Accuracy", "${stats.accuracy}%")
        StatItem("Learning streak", "${stats.currentStreak} days")

        Text(
            text = "The starter version only keeps progress while the app is open.",
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun StatItem(label: String, value: String) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(label)
            Text(value, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun SettingsScreen(
    uiState: AstronomyUiState,
    onSoundChanged: (Boolean) -> Unit,
    onDifficultyChanged: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Sound effects")
            Switch(
                checked = uiState.soundEnabled,
                onCheckedChange = onSoundChanged
            )
        }

        Text(
            text = "Difficulty",
            style = MaterialTheme.typography.titleMedium
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("Easy", "Medium", "Hard").forEach { difficulty ->
                FilterChip(
                    selected = uiState.difficulty == difficulty,
                    onClick = { onDifficultyChanged(difficulty) },
                    label = { Text(difficulty) }
                )
            }
        }

        Text(
            text = "No account or personal information is required.",
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

package com.example.cp3406_a3_edu_app.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.cp3406_a3_edu_app.data.LearningTopic
import com.example.cp3406_a3_edu_app.data.LearningStats
import com.example.cp3406_a3_edu_app.data.local.QuizAttempt
import com.example.cp3406_a3_edu_app.data.network.ApodPhoto

private data class NavItem(
    val route: String,
    val title: String
)

private val navItems = listOf(
    NavItem("home", "Home"),
    NavItem("learn", "Learn"),
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
                        modifier = Modifier
                            .testTag("nav_${item.route}")
                            .semantics {
                                contentDescription = "${item.title} tab"
                            },
                        selected = currentRoute == item.route ||
                            (item.route == "learn" && currentRoute == "solar_system"),
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
                    apodUiState = viewModel.apodUiState,
                    onRetry = viewModel::loadAstronomyPicture,
                    onOpenLearning = { navController.navigate("learn") },
                    onStartQuiz = { navController.navigate("quiz") }
                )
            }

            composable("learn") {
                LearningScreen(
                    topics = viewModel.learningTopics,
                    onOpenSolarSystem = { navController.navigate("solar_system") }
                )
            }

            composable("solar_system") {
                SolarSystemScreen(
                    planets = viewModel.planets,
                    onBack = { navController.navigateUp() }
                )
            }

            composable("quiz") {
                QuizScreen(
                    viewModel = viewModel,
                    uiState = uiState
                )
            }

            composable("stats") {
                StatsScreen(
                    stats = uiState.stats,
                    recentAttempts = uiState.recentAttempts
                )
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
    apodUiState: ApodUiState,
    onRetry: () -> Unit,
    onOpenLearning: () -> Unit,
    onStartQuiz: () -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("home_screen"),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Stellar Academy",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text("Learn basic astronomy through short lessons and quizzes.")
        }

        item {
            Text(
                text = "Astronomy Picture of the Day",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            when (apodUiState) {
                is ApodUiState.Loading -> ApodLoadingCard()
                is ApodUiState.Success -> ApodCard(apodUiState.photo)
                is ApodUiState.Error -> ApodErrorCard(onRetry)
            }
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
                    Text("Answer five random questions about astronomy.")
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
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Learning Library",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text("Read twelve short lessons before testing your knowledge.")
                    OutlinedButton(
                        onClick = onOpenLearning,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Open Lessons")
                    }
                }
            }
        }
    }
}

@Composable
private fun LearningScreen(
    topics: List<LearningTopic>,
    onOpenSolarSystem: () -> Unit
) {
    var expandedTopicId by rememberSaveable { mutableStateOf<Int?>(null) }
    val uriHandler = LocalUriHandler.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("learning_screen"),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "Learning Library",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text("Choose a topic and read its key facts.")
        }

        item {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Interactive Solar System",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text("Watch the planets orbit and tap each one to learn more.")
                    Text(
                        text = "Covers 12 quiz questions",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Button(
                        onClick = onOpenSolarSystem,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Explore the Model")
                    }
                }
            }
        }

        items(topics, key = { it.id }) { topic ->
            val isExpanded = expandedTopicId == topic.id

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = topic.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(topic.summary)

                    if (topic.questionIds.isNotEmpty()) {
                        Text(
                            text = "Covers ${topic.questionIds.size} quiz questions",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }

                    if (isExpanded) {
                        topic.facts.forEach { fact ->
                            Text("• $fact")
                        }

                        TextButton(onClick = { uriHandler.openUri(topic.sourceUrl) }) {
                            Text("Read the NASA source")
                        }
                    }

                    OutlinedButton(
                        onClick = {
                            expandedTopicId = if (isExpanded) null else topic.id
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(if (isExpanded) "Show Less" else "Start Reading")
                    }
                }
            }
        }
    }
}

@Composable
private fun ApodLoadingCard() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}

@Composable
private fun ApodErrorCard(onRetry: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text("Unable to load today's picture.")
            Text(
                text = "Check the internet connection and try again.",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Button(onClick = onRetry) {
                Text("Retry")
            }
        }
    }
}

@Composable
private fun ApodCard(photo: ApodPhoto) {
    val imageUrl =
        if (photo.mediaType == "image") photo.url else photo.thumbnailUrl

    Card(modifier = Modifier.fillMaxWidth()) {
        Column {
            if (imageUrl != null) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = photo.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f),
                    contentScale = ContentScale.Crop
                )
            } else {
                Text(
                    text = "Today's NASA item is a video.",
                    modifier = Modifier.padding(16.dp)
                )
            }

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = photo.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = photo.date,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = photo.explanation,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
                photo.copyright?.let {
                    Text(
                        text = "Credit: $it",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
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
        modifier = Modifier
            .fillMaxSize()
            .testTag("quiz_screen"),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "Question ${uiState.questionIndex + 1} of ${viewModel.questions.size}",
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "${uiState.difficulty} difficulty",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
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
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("answer_$index")
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
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("quiz_action")
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
private fun StatsScreen(
    stats: LearningStats,
    recentAttempts: List<QuizAttempt>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("stats_screen"),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "Learning Statistics",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }

        item { StatItem("Completed quizzes", stats.completedQuizzes.toString()) }
        item { StatItem("Correct answers", stats.correctAnswers.toString()) }
        item { StatItem("Total answers", stats.totalAnswers.toString()) }
        item { StatItem("Accuracy", "${stats.accuracy}%") }

        item {
            Text(
                text = "Recent Answers",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        if (recentAttempts.isEmpty()) {
            item {
                Text(
                    text = "Complete a question to start your history.",
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            itemsIndexed(recentAttempts) { _, attempt ->
                AttemptItem(attempt)
            }
        }
    }
}

@Composable
private fun AttemptItem(attempt: QuizAttempt) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = if (attempt.isCorrect) "Correct" else "Incorrect",
                color = if (attempt.isCorrect) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.tertiary
                },
                fontWeight = FontWeight.Bold
            )
            Text(
                text = attempt.questionText,
                modifier = Modifier.weight(1f)
            )
        }
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
            .testTag("settings_screen")
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
                onCheckedChange = onSoundChanged,
                modifier = Modifier.testTag("sound_switch")
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
                    modifier = Modifier.testTag("difficulty_${difficulty.lowercase()}"),
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

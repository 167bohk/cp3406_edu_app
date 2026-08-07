package com.example.cp3406_a3_edu_app.ui

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cp3406_a3_edu_app.data.PlanetInfo
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.hypot
import kotlin.math.min
import kotlin.math.sin

@Composable
fun SolarSystemScreen(
    planets: List<PlanetInfo>,
    onBack: () -> Unit
) {
    var selectedPlanetName by rememberSaveable { mutableStateOf("Earth") }
    val selectedPlanet = planets.first { it.name == selectedPlanetName }
    val uriHandler = LocalUriHandler.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .testTag("solar_system_screen"),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            OutlinedButton(onClick = onBack) {
                Text("Back to Lessons")
            }
        }

        item {
            Text(
                text = "Interactive Solar System",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text("Tap a moving planet to explore it.")
            Text(
                text = "Planet sizes, distances and speeds are adjusted to fit the screen.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        item {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = "Planet groups",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text("Rocky planets: Mercury, Venus, Earth and Mars.")
                    Text("Gas giants: Jupiter and Saturn.")
                    Text("Ice giants: Uranus and Neptune.")
                }
            }
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF050816))
            ) {
                SolarSystemCanvas(
                    planets = planets,
                    selectedPlanetName = selectedPlanetName,
                    onPlanetSelected = { selectedPlanetName = it.name }
                )
            }
        }

        item {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                items(planets, key = { it.name }) { planet ->
                    FilterChip(
                        selected = selectedPlanetName == planet.name,
                        onClick = { selectedPlanetName = planet.name },
                        label = { Text(planet.name) }
                    )
                }
            }
        }

        item {
            PlanetDetailCard(
                planet = selectedPlanet,
                onOpenSource = { uriHandler.openUri(selectedPlanet.sourceUrl) }
            )
        }
    }
}

@Composable
private fun SolarSystemCanvas(
    planets: List<PlanetInfo>,
    selectedPlanetName: String,
    onPlanetSelected: (PlanetInfo) -> Unit
) {
    val transition = rememberInfiniteTransition(label = "planet orbits")
    val orbitAngle = transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 20_000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "orbit angle"
    )

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .semantics {
                contentDescription = "Animated Solar System. Tap a planet to select it."
            }
            .pointerInput(planets) {
                detectTapGestures { tapPosition ->
                    val nearestPlanet = planets.withIndex().minByOrNull { item ->
                        val position = planetPosition(
                            index = item.index,
                            planet = item.value,
                            width = size.width.toFloat(),
                            height = size.height.toFloat(),
                            baseAngle = orbitAngle.value
                        )
                        hypot(tapPosition.x - position.x, tapPosition.y - position.y)
                    }

                    nearestPlanet?.let { item ->
                        val position = planetPosition(
                            index = item.index,
                            planet = item.value,
                            width = size.width.toFloat(),
                            height = size.height.toFloat(),
                            baseAngle = orbitAngle.value
                        )
                        val distance = hypot(
                            tapPosition.x - position.x,
                            tapPosition.y - position.y
                        )

                        if (distance <= 28.dp.toPx()) {
                            onPlanetSelected(item.value)
                        }
                    }
                }
            }
    ) {
        repeat(45) { index ->
            val x = ((index * 73) % 100) / 100f * size.width
            val y = ((index * 41 + 17) % 100) / 100f * size.height
            drawCircle(
                color = Color.White.copy(alpha = 0.45f),
                radius = if (index % 5 == 0) 1.5f else 0.8f,
                center = Offset(x, y)
            )
        }

        val centre = Offset(size.width / 2f, size.height / 2f)
        val maximumOrbitRadius = min(size.width, size.height) * 0.46f

        planets.indices.forEach { index ->
            val orbitRadius = maximumOrbitRadius * (index + 2f) / 10f
            drawCircle(
                color = Color.White.copy(alpha = 0.18f),
                radius = orbitRadius,
                center = centre,
                style = Stroke(width = 1.dp.toPx())
            )
        }

        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(Color(0xFFFFF176), Color(0xFFFF9800)),
                center = centre,
                radius = 22.dp.toPx()
            ),
            radius = 18.dp.toPx(),
            center = centre
        )

        planets.forEachIndexed { index, planet ->
            val position = planetPosition(
                index = index,
                planet = planet,
                width = size.width,
                height = size.height,
                baseAngle = orbitAngle.value
            )
            val radius = planet.displaySize.dp.toPx()

            if (planet.name == selectedPlanetName) {
                drawCircle(
                    color = Color.White,
                    radius = radius + 4.dp.toPx(),
                    center = position,
                    style = Stroke(width = 2.dp.toPx())
                )
            }

            if (planet.name == "Saturn") {
                drawOval(
                    color = Color(0xFFE8D5A5),
                    topLeft = Offset(position.x - radius * 1.8f, position.y - radius * 0.55f),
                    size = Size(radius * 3.6f, radius * 1.1f),
                    style = Stroke(width = 1.dp.toPx())
                )
            }

            drawCircle(
                color = planetColour(planet.name),
                radius = radius,
                center = position
            )
        }
    }
}

private fun planetPosition(
    index: Int,
    planet: PlanetInfo,
    width: Float,
    height: Float,
    baseAngle: Float
): Offset {
    val centre = Offset(width / 2f, height / 2f)
    val maximumOrbitRadius = min(width, height) * 0.46f
    val orbitRadius = maximumOrbitRadius * (index + 2f) / 10f
    val angle = baseAngle * planet.orbitSpeed + index * 40f
    val radians = angle * PI / 180.0

    return Offset(
        x = centre.x + cos(radians).toFloat() * orbitRadius,
        y = centre.y + sin(radians).toFloat() * orbitRadius
    )
}

private fun planetColour(name: String): Color = when (name) {
    "Mercury" -> Color(0xFF9E9E9E)
    "Venus" -> Color(0xFFFFCC80)
    "Earth" -> Color(0xFF42A5F5)
    "Mars" -> Color(0xFFEF6C4D)
    "Jupiter" -> Color(0xFFD7A86E)
    "Saturn" -> Color(0xFFE8D5A5)
    "Uranus" -> Color(0xFF80DEEA)
    else -> Color(0xFF4267B2)
}

@Composable
private fun PlanetDetailCard(
    planet: PlanetInfo,
    onOpenSource: () -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = planet.name,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Text("Planet ${planet.orderFromSun} from the Sun • ${planet.planetType}")
            Text(planet.description)
            Text(
                text = "Appears in ${planet.questionIds.size} quiz question${if (planet.questionIds.size == 1) "" else "s"}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary
            )

            HorizontalDivider()
            PlanetValue("Average distance", planet.distanceFromSun)
            PlanetValue("Length of day", planet.dayLength)
            PlanetValue("Length of year", planet.yearLength)

            HorizontalDivider()
            Text(
                text = "Fun facts",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            planet.funFacts.forEach { fact ->
                Text("• $fact")
            }

            TextButton(onClick = onOpenSource) {
                Text("Read more on NASA")
            }
        }
    }
}

@Composable
private fun PlanetValue(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(value, fontWeight = FontWeight.Bold)
    }
}

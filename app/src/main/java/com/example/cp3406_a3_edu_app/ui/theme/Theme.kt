package com.example.cp3406_a3_edu_app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val SpaceColorScheme = darkColorScheme(
    primary = StarBlue,
    secondary = AuroraPurple,
    tertiary = SolarGold,
    background = SpaceNavy,
    surface = SpaceSurface,
    surfaceVariant = SpaceSurfaceHigh,
    onPrimary = SpaceNavy,
    onBackground = CloudWhite,
    onSurface = CloudWhite
)

@Composable
fun Cp3406_a3_edu_appTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = SpaceColorScheme,
        typography = Typography,
        content = content
    )
}

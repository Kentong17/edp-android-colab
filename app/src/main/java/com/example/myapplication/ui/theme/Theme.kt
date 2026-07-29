package com.example.myapplication.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = MaroonPrimaryDark,
    onPrimary = MaroonOnPrimaryDark,
    primaryContainer = MaroonPrimaryContainerDark,
    onPrimaryContainer = MaroonOnPrimaryContainerDark,
    secondary = MaroonSecondaryDark,
    onSecondary = MaroonOnSecondaryDark,
    secondaryContainer = MaroonSecondaryContainerDark,
    onSecondaryContainer = MaroonOnSecondaryContainerDark,
    tertiary = MaroonTertiaryDark,
    onTertiary = MaroonOnTertiaryDark,
    tertiaryContainer = MaroonTertiaryContainerDark,
    onTertiaryContainer = MaroonOnTertiaryContainerDark
)

private val LightColorScheme = lightColorScheme(
    primary = MaroonPrimary,
    onPrimary = MaroonOnPrimary,
    primaryContainer = MaroonPrimaryContainer,
    onPrimaryContainer = MaroonOnPrimaryContainer,
    secondary = MaroonSecondary,
    onSecondary = MaroonOnSecondary,
    secondaryContainer = MaroonSecondaryContainer,
    onSecondaryContainer = MaroonOnSecondaryContainer,
    tertiary = MaroonTertiary,
    onTertiary = MaroonOnTertiary,
    tertiaryContainer = MaroonTertiaryContainer,
    onTertiaryContainer = MaroonOnTertiaryContainer,
    background = androidx.compose.ui.graphics.Color.White,
    surface = androidx.compose.ui.graphics.Color.White,
    onBackground = androidx.compose.ui.graphics.Color.Black,
    onSurface = androidx.compose.ui.graphics.Color.Black
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is disabled to force the Liceo Maroon theme
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

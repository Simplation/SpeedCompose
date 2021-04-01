/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Green900,
    onPrimary = Color.White,
    secondary = Green300,
    onSecondary = Gray,
    background = Gray,
    onBackground = Color.White,
    surface = White150,
    onSurface = White850
)

private val LightColorPalette = lightColors(
    primary = Pink100,
    onPrimary = Gray,
    secondary = Pink900,
    onSecondary = Color.White,
    background = Color.White,
    onBackground = Gray,
    surface = White850,
    onSurface = Gray,
)

@Composable
fun SpeedTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = SpeedTypography,
        shapes = SpeedShapes,
        content = content
    )
}

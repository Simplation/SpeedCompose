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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.booleanResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.ui.home.HomeScreen
import com.example.androiddevchallenge.ui.theme.SpeedTheme
import com.example.androiddevchallenge.ui.welcome.LoginScreen
import com.example.androiddevchallenge.ui.welcome.WelcomeScreen
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

@ExperimentalFoundationApi
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This app draws behind the system bars, so we want to handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            SpeedApp()
        }
    }
}

enum class AppState {
    OnBoarding, Login, Home
}

@ExperimentalFoundationApi
@Composable
fun SpeedApp() {
    ProvideWindowInsets {
        SpeedTheme {
            val (appState, setAppState) = remember { mutableStateOf(AppState.OnBoarding) }
            when (appState) {
                AppState.OnBoarding -> WelcomeScreen {
                    setAppState(AppState.Login)
                }
                AppState.Login -> LoginScreen {
                    setAppState(AppState.Home)
                }
                AppState.Home -> HomeScreen()
            }
            val showGrid = booleanResource(id = R.bool.debug_show_grid)
            if (showGrid) {
                GridLayer()
            }
        }
    }
}

@Composable
fun GridLayer() {
    val offset = 8.dp
    Canvas(modifier = Modifier.fillMaxSize()) {
        var x = 0f
        while (x < size.width) {
            drawLine(
                start = Offset(x = x, y = 0f),
                end = Offset(x = x, y = size.height),
                strokeWidth = 1f,
                color = Color.Red.copy(alpha = .3f)
            )
            x += offset.toPx()
        }
        var y = 0f
        while (y < size.height) {
            drawLine(
                start = Offset(x = 0f, y = y),
                end = Offset(x = size.width, y = y),
                strokeWidth = 1f,
                color = Color.Red.copy(alpha = .3f)
            )
            y += offset.toPx()
        }
    }
}

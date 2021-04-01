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
package com.example.androiddevchallenge.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.myThemes
import com.example.androiddevchallenge.model.Theme
import com.example.androiddevchallenge.ui.theme.SpeedTheme
import com.example.androiddevchallenge.ui.theme.SpeedTypography

@Composable
fun ThemesBrowser(themes: List<Theme>, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = R.string.browse_themes),
            modifier = Modifier
                .paddingFromBaseline(top = 32.dp, bottom = 16.dp)
                .then(modifier),
            style = SpeedTypography.h1
        )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 2.dp)
        ) {
            val themesCount = themes.size
            itemsIndexed(themes) { index, theme ->
                if (themesCount > 0 && index < themesCount - 1) {
                    Spacer(Modifier.width(8.dp))
                }
                ThemeCard(stringResource(theme.name), painterResource(theme.picture))
            }
        }
    }
}

@Composable
fun ThemeCard(name: String, picture: Painter) {
    Card(modifier = Modifier.size(136.dp), shape = MaterialTheme.shapes.small) {
        Column(modifier = Modifier.clickable { }) {
            Image(
                painter = picture,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(96.dp),
                contentScale = ContentScale.FillBounds
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(text = name, textAlign = TextAlign.Center, style = SpeedTypography.h2)
            }
        }
    }
}

@Preview
@Composable
fun CollectionsLightPreview() {
    SpeedTheme {
        ThemesBrowser(themes = myThemes, modifier = Modifier.padding(horizontal = 16.dp))
    }
}

@Preview
@Composable
fun CollectionsDarkPreview() {
    SpeedTheme(darkTheme = true) {
        ThemesBrowser(themes = myThemes, modifier = Modifier.padding(horizontal = 16.dp))
    }
}

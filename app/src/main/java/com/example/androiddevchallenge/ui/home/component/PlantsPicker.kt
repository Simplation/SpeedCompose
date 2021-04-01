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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.myPlants
import com.example.androiddevchallenge.model.Plant
import com.example.androiddevchallenge.ui.theme.SpeedTheme
import com.example.androiddevchallenge.ui.theme.SpeedTypography

@Composable
fun PlantsPicker(plants: List<Plant>, modifier: Modifier = Modifier) {
    Column {
        Row(modifier = modifier, verticalAlignment = Alignment.Bottom) {
            Text(
                text = stringResource(id = R.string.design_your_home_garden),
                modifier = Modifier
                    .weight(1f)
                    .paddingFromBaseline(top = 40.dp),
                style = SpeedTypography.h1
            )
            Icon(
                imageVector = Icons.Default.FilterList,
                contentDescription = stringResource(id = R.string.filter_plants),
                modifier = Modifier
                    .clickable { }
                    .size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp)) {
            itemsIndexed(plants) { index, plant ->
                val (isSelected, onSelect) = remember { mutableStateOf(index == 0) }
                PlantDescription(
                    name = stringResource(plant.name),
                    picture = painterResource(plant.picture),
                    description = stringResource(plant.description),
                    isSelected = isSelected,
                    onToggle = onSelect
                )
            }
        }
    }
}

@Composable
fun PlantDescription(
    name: String,
    picture: Painter,
    description: String,
    isSelected: Boolean,
    onToggle: (Boolean) -> Unit
) {
    Column {
        Row {
            Image(
                painter = picture, contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(MaterialTheme.shapes.small),
                contentScale = ContentScale.FillBounds
            )

            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp)
                    ) {
                        Text(
                            text = name,
                            modifier = Modifier.paddingFromBaseline(top = 24.dp),
                            style = SpeedTypography.h2
                        )
                        Text(
                            text = description,
                            modifier = Modifier.paddingFromBaseline(bottom = 24.dp)
                        )
                    }
                    Checkbox(
                        checked = isSelected,
                        onCheckedChange = onToggle,
                        colors = CheckboxDefaults.colors(
                            checkmarkColor = MaterialTheme.colors.onSecondary,
                            checkedColor = MaterialTheme.colors.secondary
                        )
                    )
                }
                Divider(
                    modifier = Modifier
                        .height(1.dp)
                        .padding(start = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ActivitiesLightPreview() {
    SpeedTheme {
        PlantsPicker(plants = myPlants, modifier = Modifier.padding(horizontal = 16.dp))
    }
}

@Preview
@Composable
private fun ActivitiesDarkPreview() {
    SpeedTheme(darkTheme = true) {
        PlantsPicker(plants = myPlants, modifier = Modifier.padding(horizontal = 16.dp))
    }
}

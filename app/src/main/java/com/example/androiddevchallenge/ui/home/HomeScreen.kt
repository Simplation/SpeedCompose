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
package com.example.androiddevchallenge.ui.home

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.myPlants
import com.example.androiddevchallenge.data.myThemes
import com.example.androiddevchallenge.ui.component.SearchComponent
import com.example.androiddevchallenge.ui.home.component.PlantsPicker
import com.example.androiddevchallenge.ui.home.component.ThemesBrowser
import com.example.androiddevchallenge.ui.theme.SpeedTheme
import dev.chrisbanes.accompanist.insets.navigationBarsHeight
import dev.chrisbanes.accompanist.insets.navigationBarsPadding

private enum class HomeTabs(@StringRes val titleRes: Int, val icon: ImageVector) {
    Home(R.string.nav_home, Icons.Default.Home),
    Favorites(R.string.nav_favorites, Icons.Default.FavoriteBorder),
    Profile(R.string.nav_profile, Icons.Default.AccountCircle),
    Cart(R.string.nav_cart, Icons.Default.ShoppingCart)
}

@Composable
fun HomeScreen() {
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(HomeTabs.Home) }
    val tabs = HomeTabs.values()

    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = {},
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.navigationBarsHeight(additional = 56.dp),
                backgroundColor = MaterialTheme.colors.primary,
                elevation = 16.dp
            ) {
                tabs.forEach { navItem ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = navItem.icon,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        label = { Text(text = stringResource(id = navItem.titleRes)) },
                        selected = selectedTab == navItem,
                        selectedContentColor = MaterialTheme.colors.onPrimary,
                        unselectedContentColor = MaterialTheme.colors.onPrimary.copy(alpha = ContentAlpha.medium),
                        modifier = Modifier.navigationBarsPadding(),
                        onClick = { /*setSelectedTab(navItem)*/ }
                    )
                }
            }
        }
    ) {
        Column {
            Spacer(modifier = Modifier.height(40.dp))
            SearchComponent(modifier = Modifier.padding(horizontal = 16.dp))
            ThemesBrowser(
                myThemes,
                Modifier.padding(horizontal = 16.dp)
            )
            PlantsPicker(
                myPlants,
                Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun HomeLightPreview() {
    SpeedTheme {
        HomeScreen()
    }
}

@Preview
@Composable
fun HomeDarkPreview() {
    SpeedTheme(darkTheme = true) {
        HomeScreen()
    }
}

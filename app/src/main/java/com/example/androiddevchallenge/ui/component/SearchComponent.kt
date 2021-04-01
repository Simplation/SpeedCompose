package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.SpeedTheme

@Composable
fun SearchComponent(modifier: Modifier = Modifier) {
    var query by remember { mutableStateOf("") }
    OutlinedTextField(
        value = query,
        onValueChange = { query = it },
        modifier = modifier.fillMaxWidth(),
        maxLines = 1,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
        },
        placeholder = {
            Box(contentAlignment = Alignment.CenterStart) {
                Text(text = stringResource(id = R.string.search), style = LocalTextStyle.current)
            }
        }
    )
}

@Preview
@Composable
private fun SearchComponentLightPreview() {
    SpeedTheme {
        SearchComponent()
    }
}

@Preview
@Composable
private fun SearchComponentDarkPreview() {
    SpeedTheme(darkTheme = true) {
        SearchComponent()
    }
}

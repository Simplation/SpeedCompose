package com.example.androiddevchallenge.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Surface
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.SpeedTheme
import com.example.androiddevchallenge.ui.welcome.component.WelcomeButton

@Composable
fun WelcomeScreen(onSignIn: () -> Unit) {
    Surface(color = MaterialTheme.colors.primary) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(
                painter = welcomeBackground(),
                contentDescription = null,
                Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            Column(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = welcomeIllos(),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 72.dp, start = 88.dp, bottom = 48.dp)
                )
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        fontFamily = FontFamily.Monospace,
                        fontSize = 24.sp
                    )

                    Text(
                        text = stringResource(id = R.string.app_subtitle),
                        modifier = Modifier.paddingFromBaseline(top = 32.dp, bottom = 40.dp),
                        style = MaterialTheme.typography.subtitle1
                    )

                    WelcomeButton(onClick = {}) {
                        Text(text = stringResource(id = R.string.welcome_create_account))
                    }

                    TextButton(
                        onClick = onSignIn,
                        // FIXME color isn't correct in dark
                        colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colors.secondary)
                    ) {
                        Text(text = stringResource(id = R.string.welcome_login))
                    }
                }
            }
        }
    }
}

@Composable
fun welcomeIllos() = painterResource(
    id = when {
        isSystemInDarkTheme() -> R.drawable.dark_welcome_illos
        else -> R.drawable.light_welcome_illos
    }
)

@Composable
private fun welcomeBackground() = painterResource(
    id = when {
        isSystemInDarkTheme() -> R.drawable.dark_welcome_bg
        else -> R.drawable.light_welcome_bg
    }
)

@Preview
@Composable
fun WelcomeLightPreview() {
    SpeedTheme {
        WelcomeScreen {}
    }
}

@Preview
@Composable
fun WelcomeDarkPreview() {
    SpeedTheme(darkTheme = true) {
        WelcomeScreen {}
    }
}

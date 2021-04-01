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
package com.example.androiddevchallenge.ui.welcome

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.SpeedTheme
import com.example.androiddevchallenge.ui.theme.SpeedTypography
import com.example.androiddevchallenge.ui.welcome.component.WelcomeButton

@Composable
fun LoginScreen(onSignedIn: () -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.login_login_title),
                    modifier = Modifier.paddingFromBaseline(top = 184.dp, bottom = 16.dp),
                    style = SpeedTypography.h1
                )

                var email by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.login_email_address),
                            style = SpeedTypography.body1
                        )
                    }
                )

                var password by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    placeholder = {
                        Text(
                            text = stringResource(id = R.string.login_password),
                            style = SpeedTypography.body1
                        )
                    }
                )

                Text(
                    text = buildAnnotatedString {
                        append("By clicking below, you agree to our ")
                        withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                            append("Terms of Use")
                        }
                        append(" and consent to our ")
                        withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                            append("Privacy Policy")
                        }
                        append(".")
                    },
                    modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 16.dp),
                    textAlign = TextAlign.Center,
                    style = SpeedTypography.h2
                )

                WelcomeButton(onClick = onSignedIn) {
                    Text(text = stringResource(id = R.string.login_login))
                }
            }
        }
    }
}

@Preview
@Composable
private fun LoginLightPreview() {
    SpeedTheme {
        LoginScreen {}
    }
}

@Preview
@Composable
private fun LoginDarkPreview() {
    SpeedTheme(darkTheme = true) {
        LoginScreen {}
    }
}

package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.androiddevchallenge.R

data class Theme(@StringRes val name: Int, @DrawableRes val picture: Int)

data class Plant(
    @StringRes val name: Int,
    @DrawableRes val picture: Int,
    @StringRes val description: Int = R.string.dummy_desc
)

package com.sonu.jetpackcomposeexamples

import androidx.annotation.DrawableRes

data class BottomMenuContent(
    val title: String,
    @DrawableRes val itemId: Int
)

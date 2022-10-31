package com.anoir.noteanoir.presentation.common.components

import androidx.compose.material.TopAppBar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun TopBar(
    title: String) {
    TopAppBar (
        title = {
            Text(
                text = title,
              //  color = MaterialTheme.colors.white
            )
        }
    )
}
package com.anoirdev.test.presentation.screens.home

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.anoirdev.test.R
import com.anoirdev.test.presentation.common.components.TopBar
import com.anoirdev.test.presentation.screens.home.components.HomeBody

@Composable
@ExperimentalMaterialApi
fun HomeScreen(navHostController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {
            TopBar(stringResource(id = R.string.home_title))
        },
        content = {
            HomeBody()
        },

        )
}

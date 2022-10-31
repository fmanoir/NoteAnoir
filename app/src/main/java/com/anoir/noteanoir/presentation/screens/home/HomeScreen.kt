package com.anoir.noteanoir.presentation.screens.home

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.anoir.noteanoir.R
import com.anoir.noteanoir.presentation.screens.home.components.HomeBody
import com.anoir.noteanoir.presentation.common.components.TopBar
import com.anoir.noteanoir.presentation.common.navigation.Screen

@Composable
@ExperimentalMaterialApi
fun HomeScreen(navHostController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {
            TopBar(stringResource(id = R.string.home_title))
        }, content = { HomeBody() },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navHostController.navigate(Screen.NoteAddScreen.route) },
                backgroundColor = MaterialTheme.colors.primary,
            ) {
                Icon(Icons.Filled.Add, "")
            }
        }

    )
}

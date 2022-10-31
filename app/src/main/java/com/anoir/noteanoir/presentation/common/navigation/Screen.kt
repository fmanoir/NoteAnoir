package com.anoir.noteanoir.presentation.common.navigation

import com.anoir.noteanoir.data.common.HOME_SCREEN
import com.anoir.noteanoir.data.common.NOTE_ADD_SCREEN


sealed class Screen(val route: String) {
    object HomeScreen: Screen(HOME_SCREEN)
    object NoteAddScreen: Screen(NOTE_ADD_SCREEN)
}
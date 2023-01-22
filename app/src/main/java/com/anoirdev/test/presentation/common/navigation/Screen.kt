package com.anoirdev.test.presentation.common.navigation

import com.anoirdev.test.utlis.HOME_SCREEN


sealed class Screen(val route: String) {
    object HomeScreen : Screen(HOME_SCREEN)
}
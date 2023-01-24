package com.anoirdev.test.presentation.event


data class EventPresentation(
    val leftTeamName: String,
    val leftTeamScore: String,
    val colorLeftTeamScore: Int,
    val rightTeamName: String,
    val rightTeamScore: String,
    val colorRightTeamScore: Int,
    val date: String,
    val time: String
)



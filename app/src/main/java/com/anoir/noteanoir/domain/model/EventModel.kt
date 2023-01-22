package com.anoir.noteanoir.domain.model

/*
Event Domain
 */

data class EventModel(
    val left_team_name: String,
    val left_team_score: Int,
    val right_team_name: String,
    val right_team_score: Int,
    val date: String,
    val time: String
)
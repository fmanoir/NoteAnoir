package com.anoirdev.test.domain.model

/*
Event Domain
 */

data class EventModel(
    val leftTeamName: String,
    val leftTeamScore: Int,
    val rightTeamName: String,
    val rightTeamScore: Int,
    val date: String,
    val time: String
)
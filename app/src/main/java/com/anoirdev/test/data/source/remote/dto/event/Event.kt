package com.anoirdev.test.data.source.remote.dto.event


data class Event(
    val left_team: Team,
    val right_team: Team,
    val date: String,
    val time: String,
)
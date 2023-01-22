package com.anoirdev.test.presentation.xml

import com.anoirdev.test.domain.model.EventModel


data class EventPresentation(
    val leftTeamName: String,
    val leftTeamScore: String,
    val rightTeamName: String,
    val rightTeamScore: String,
    val date: String,
    val time: String
)


fun EventModel.toPresentation() =
    EventPresentation(
        leftTeamName = this.leftTeamName,
        leftTeamScore = this.leftTeamScore.toString(),
        rightTeamName = this.rightTeamName,
        rightTeamScore = this.rightTeamScore.toString(),
        date = this.date,
        time = this.time
    )
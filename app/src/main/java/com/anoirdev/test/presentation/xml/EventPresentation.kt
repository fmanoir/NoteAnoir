package com.anoirdev.test.presentation.xml

import com.anoirdev.test.domain.model.EventModel


data class EventPresentation(
    val leftTeamName: String,
    val leftTeamScore: Int,
    val rightTeamName: String,
    val rightTeamScore: Int,
    val date: String,
    val time: String
)


fun EventModel.toPresentation() =
    EventPresentation(
        leftTeamName = this.leftTeamName,
        leftTeamScore = this.leftTeamScore,
        rightTeamName = this.rightTeamName,
        rightTeamScore = this.rightTeamScore,
        date = this.date,
        time = this.time
    )
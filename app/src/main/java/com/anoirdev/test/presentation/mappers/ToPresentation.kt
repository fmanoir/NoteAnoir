package com.anoirdev.test.presentation.mappers

import com.anoirdev.test.R
import com.anoirdev.test.domain.model.EventModel
import com.anoirdev.test.presentation.event.EventPresentation

fun EventModel.toPresentation() =
    EventPresentation(
        leftTeamName = this.leftTeamName,
        leftTeamScore = this.leftTeamScore.toString(),
        colorLeftTeamScore = getColorTeam(this.leftTeamScore, this.rightTeamScore),
        rightTeamName = this.rightTeamName,
        rightTeamScore = this.rightTeamScore.toString(),
        colorRightTeamScore = getColorTeam(this.rightTeamScore, this.leftTeamScore),
        date = this.date,
        time = this.time
    )


fun getColorTeam(leftTeamScore: Int, rightTeamScore: Int): Int {
    return if (rightTeamScore < leftTeamScore) {
        R.color.grean
    } else {
        if (rightTeamScore > leftTeamScore) {
            R.color.red
        } else {
            R.color.gris
        }
    }
}

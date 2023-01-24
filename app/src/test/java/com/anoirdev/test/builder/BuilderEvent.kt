package com.anoirdev.test.builder

import com.anoirdev.test.R
import com.anoirdev.test.data.source.local.entity.EventEntity
import com.anoirdev.test.data.source.remote.dto.event.Event
import com.anoirdev.test.data.source.remote.dto.event.EventsDto
import com.anoirdev.test.data.source.remote.dto.event.Team
import com.anoirdev.test.domain.model.EventModel
import com.anoirdev.test.presentation.event.EventPresentation

class BuilderEvent {

    companion object {
        val BUILD_EVENT_PRESENTATION = EventPresentation(
            leftTeamScore = "4",
            leftTeamName = "FC Thiais",
            rightTeamScore = "1",
            rightTeamName = "FC Olympiens",
            date = "Samedi 6 décembre",
            time = "17:30",
            colorRightTeamScore = R.color.red,
            colorLeftTeamScore = R.color.grean
        )
        val BUILD_EVENT_ENTITY = EventEntity(
            left_team_score = 4,
            left_team_name = "FC Thiais",
            right_team_score = 1,
            right_team_name = "FC Olympiens",
            date = "Samedi 6 décembre",
            time = "17:30",
            id = 1
        )
        val BUILD_EVENT_MODEL = EventModel(
            leftTeamScore = 4,
            leftTeamName = "FC Thiais",
            rightTeamScore = 1,
            rightTeamName = "FC Olympiens",
            date = "Samedi 6 décembre",
            time = "17:30"
        )
        val BUILD_EVENT_DTO = EventsDto(
            events = listOf(
                Event(
                    left_team = Team(name = "FC Thiais", score = 4),
                    right_team = Team(name = "FC Olympiens", score = 1),
                    date = "Samedi 6 décembre",
                    time = "17:30"
                )
            )
        )
    }
}

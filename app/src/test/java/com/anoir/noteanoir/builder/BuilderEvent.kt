package com.anoir.noteanoir.builder

import com.anoir.noteanoir.data.source.local.entity.EventEntity
import com.anoir.noteanoir.data.source.remote.dto.event.Event
import com.anoir.noteanoir.data.source.remote.dto.event.EventsDto
import com.anoir.noteanoir.data.source.remote.dto.event.Team
import com.anoir.noteanoir.domain.model.EventModel

class BuilderEvent {

    companion object {
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
            left_team_score = 4,
            left_team_name = "FC Thiais",
            right_team_score = 1,
            right_team_name = "FC Olympiens",
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

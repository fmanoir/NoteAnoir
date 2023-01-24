package com.anoirdev.test.data.source.mappers

import com.anoirdev.test.data.source.local.entity.EventEntity
import com.anoirdev.test.data.source.remote.dto.event.Event

fun Event.toEntity(): EventEntity =
    EventEntity(
        id = 0,
        left_team_name = left_team.name,
        right_team_name = right_team.name,
        left_team_score = left_team.score,
        right_team_score = right_team.score,
        date = date,
        time = time,
    )
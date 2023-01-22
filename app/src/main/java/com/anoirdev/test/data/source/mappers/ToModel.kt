package com.anoirdev.test.data.source.mappers

import com.anoirdev.test.data.source.local.entity.EventEntity
import com.anoirdev.test.domain.model.EventModel

fun EventEntity.toModel(): EventModel =
    EventModel(
        leftTeamName = left_team_name,
        leftTeamScore = left_team_score,
        rightTeamName = right_team_name,
        rightTeamScore = right_team_score,
        date = date,
        time = time,
    )

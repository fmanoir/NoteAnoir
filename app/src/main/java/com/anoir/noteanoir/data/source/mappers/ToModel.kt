package com.anoir.noteanoir.data.source.mappers

import com.anoir.noteanoir.data.source.local.entity.EventEntity
import com.anoir.noteanoir.domain.model.EventModel

fun EventEntity.toModel(): EventModel =
    EventModel(
        left_team_name = left_team_name,
        left_team_score = left_team_score,
        right_team_name = right_team_name,
        right_team_score = right_team_score,
        date = date,
        time = time,
    )

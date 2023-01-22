package com.anoirdev.test.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
Event Entity
 */
@Entity
data class EventEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val left_team_name: String,
    val left_team_score: Int,
    val right_team_name: String,
    val right_team_score: Int,
    val date: String,
    val time: String
)
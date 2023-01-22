package com.anoirdev.test.data.source.remote.dto.event

import com.google.gson.annotations.SerializedName


data class Event(
    @SerializedName(TAG_LEFT_TEAM)
    val left_team: Team,
    @SerializedName(TAG_RIGHT_TEAM)
    val right_team: Team,
    @SerializedName(TAG_DATE)
    val date: String,
    @SerializedName(TAG_TIME)
    val time: String,
) {
    companion object {
        const val TAG_LEFT_TEAM = "left_team"
        const val TAG_RIGHT_TEAM = "right_team"
        const val TAG_DATE = "date"
        const val TAG_TIME = "time"
    }
}
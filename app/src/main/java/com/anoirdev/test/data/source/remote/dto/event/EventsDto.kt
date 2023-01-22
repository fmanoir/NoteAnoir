package com.anoirdev.test.data.source.remote.dto.event

import com.google.gson.annotations.SerializedName

/*
Event Dto
 */
data class EventsDto(
    @SerializedName(TAG_EVENTS)
    val events: List<Event>,
) {
    companion object {
        const val TAG_EVENTS = "events"
    }
}
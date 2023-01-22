package com.anoirdev.test.data.source.remote.api

import com.anoirdev.test.data.source.remote.dto.event.EventsDto
import retrofit2.Response
import retrofit2.http.GET

/*
All Event API
 */

interface EventAPI {
    @GET(GET_EVENTS)
    suspend fun getEvents(): Response<List<EventsDto>>

    companion object {
        const val GET_EVENTS = "events"
    }
}
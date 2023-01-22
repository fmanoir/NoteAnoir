package com.anoir.noteanoir.data.source.remote.api

import com.anoir.noteanoir.data.source.remote.dto.event.EventsDto
import retrofit2.Response
import retrofit2.http.GET

/*
All API
 */

interface EventAPI {
    @GET(GET_EVENTS)
    suspend fun getEvents(): Response<List<EventsDto>>

    companion object {
        const val GET_EVENTS = "events"
    }
}
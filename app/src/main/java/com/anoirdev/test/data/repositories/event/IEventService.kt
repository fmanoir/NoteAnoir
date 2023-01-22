package com.anoirdev.test.data.repositories.event

import com.anoirdev.test.data.source.remote.dto.event.EventsDto
import com.anoirdev.test.utlis.sealed.Resource
import kotlinx.coroutines.flow.Flow

/*
Event Service interface
 */

interface IEventService {
    suspend fun getEvents(): Flow<Resource<EventsDto>>
}
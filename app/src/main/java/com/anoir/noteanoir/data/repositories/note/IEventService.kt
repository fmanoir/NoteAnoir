package com.anoir.noteanoir.data.repositories.note

import com.anoir.noteanoir.data.source.remote.dto.event.EventsDto
import com.anoir.noteanoir.utlis.sealed.Resource
import kotlinx.coroutines.flow.Flow
/*
Note Service interface
 */

interface IEventService {
    suspend fun getEvents(): Flow<Resource<List<EventsDto>>>
}
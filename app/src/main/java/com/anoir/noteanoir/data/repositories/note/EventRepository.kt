package com.anoir.noteanoir.data.repositories.note

import com.anoir.noteanoir.data.common.IFetchingStrategy
import com.anoir.noteanoir.data.source.mappers.toModel
import com.anoir.noteanoir.data.source.mappers.toEntity
import com.anoir.noteanoir.domain.model.EventModel
import com.anoir.noteanoir.domain.repository.IEventRepository
import com.anoir.noteanoir.utlis.sealed.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

/*
Note Repository
 */

@ExperimentalCoroutinesApi
class EventRepository @Inject constructor(
    private val eventStorage: IEventStorage,
    private val eventService: IEventService
) : IEventRepository, IFetchingStrategy {
    override suspend fun getEvents(): Flow<Resource<List<EventModel>>> {
        return fetching(
            shouldFetchFromRemote = { flowOf(true) },
            fetchFromRemote = {
                eventService.getEvents()
            },
            saveRemoteData = { listFromRemote -> listFromRemote.map { listEvents -> eventStorage.addEvents(listEvents.events.map { it.toEntity() }) } },
            fetchFromLocal = { flowOf(eventStorage.getEvents().map { it.toModel() }) }
        )
    }


}
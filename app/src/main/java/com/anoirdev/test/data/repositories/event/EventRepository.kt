package com.anoirdev.test.data.repositories.event

import com.anoirdev.test.data.common.IFetchingStrategy
import com.anoirdev.test.data.source.mappers.toModel
import com.anoirdev.test.domain.model.EventModel
import com.anoirdev.test.domain.repository.IEventRepository
import com.anoirdev.test.utlis.sealed.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

/*
Event Repository
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
            saveRemoteData = eventStorage::addEvents,
            fetchFromLocal = { flowOf(eventStorage.getEvents().map { it.toModel() }) }
        )
    }


}
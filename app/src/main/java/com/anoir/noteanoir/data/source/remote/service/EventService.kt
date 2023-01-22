package com.anoir.noteanoir.data.source.remote.service

import com.anoir.noteanoir.data.repositories.note.IEventService
import com.anoir.noteanoir.data.source.remote.api.EventAPI
import com.anoir.noteanoir.data.source.remote.common.error.IApiErrorHandler
import com.anoir.noteanoir.data.source.remote.common.network.InternetStatusInterface
import com.anoir.noteanoir.data.source.remote.dto.event.EventsDto
import com.anoir.noteanoir.utlis.sealed.Resource
import com.anoir.noteanoir.data.source.remote.common.network.IFlowNetworkRequest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/*
Service entre API and Repository
 */

class EventService @Inject constructor(
    private val eventAPI: EventAPI,
    private val apiErrorHandler: IApiErrorHandler,
    private val internetStatusInterface: InternetStatusInterface
) : IEventService, IFlowNetworkRequest {

    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun getEvents(): Flow<Resource<List<EventsDto>>> {
        return safeCall(
            internetStatusInterface = internetStatusInterface,
            apiErrorHandler = apiErrorHandler
        ) {
            eventAPI.getEvents()
        }
    }


}
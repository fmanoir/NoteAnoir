package com.anoirdev.test.data.source.remote.service

import com.anoirdev.test.data.repositories.event.IEventService
import com.anoirdev.test.data.source.remote.api.EventAPI
import com.anoirdev.test.data.source.remote.common.error.IApiErrorHandler
import com.anoirdev.test.data.source.remote.common.network.IFlowNetworkRequest
import com.anoirdev.test.data.source.remote.common.network.InternetStatusInterface
import com.anoirdev.test.data.source.remote.dto.event.EventsDto
import com.anoirdev.test.utlis.sealed.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/*
Service API
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
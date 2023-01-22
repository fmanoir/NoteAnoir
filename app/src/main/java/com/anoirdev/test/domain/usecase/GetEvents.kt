package com.anoirdev.test.domain.usecase

import com.anoirdev.test.domain.model.EventModel
import com.anoirdev.test.domain.repository.IEventRepository
import com.anoirdev.test.utlis.sealed.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/*
US to get all events
 */

class GetEvents @Inject constructor(private val eventRepository: IEventRepository) :
    EventUseCase.IGetEvents {

    override suspend fun invoke(): Flow<Resource<List<EventModel>>> {
        return eventRepository.getEvents()
    }
}
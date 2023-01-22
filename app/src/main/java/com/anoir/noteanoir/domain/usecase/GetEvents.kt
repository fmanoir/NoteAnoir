package com.anoir.noteanoir.domain.usecase

import com.anoir.noteanoir.domain.model.EventModel
import com.anoir.noteanoir.domain.repository.IEventRepository
import com.anoir.noteanoir.utlis.sealed.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/*
US to get all note
 */

class GetEvents @Inject constructor(private val eventRepository: IEventRepository) :
    EventUseCase.IGetEvents {

    override suspend fun invoke(): Flow<Resource<List<EventModel>>> {
        return eventRepository.getEvents()
    }
}
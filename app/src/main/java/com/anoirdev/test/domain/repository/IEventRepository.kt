package com.anoirdev.test.domain.repository

import com.anoirdev.test.domain.model.EventModel
import com.anoirdev.test.utlis.sealed.Resource
import kotlinx.coroutines.flow.Flow

/*
Interface Repository Note
 */

interface IEventRepository {
    suspend fun getEvents(): Flow<Resource<List<EventModel>>>
}
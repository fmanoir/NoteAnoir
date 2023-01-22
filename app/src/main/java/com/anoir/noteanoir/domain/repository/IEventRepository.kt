package com.anoir.noteanoir.domain.repository

import com.anoir.noteanoir.domain.model.EventModel
import com.anoir.noteanoir.utlis.sealed.Resource
import kotlinx.coroutines.flow.Flow

/*
Interface Repository Note
 */

interface IEventRepository {
    suspend fun getEvents(): Flow<Resource<List<EventModel>>>
}
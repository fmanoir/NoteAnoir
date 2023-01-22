package com.anoirdev.test.data.source.local.storage

import com.anoirdev.test.data.repositories.event.IEventStorage
import com.anoirdev.test.data.source.local.dao.EventDao
import com.anoirdev.test.data.source.local.entity.EventEntity
import com.anoirdev.test.data.source.mappers.toEntity
import com.anoirdev.test.data.source.remote.dto.event.EventsDto
import javax.inject.Inject


/*
Event Storage = DAO
 */

class EventStorage @Inject constructor(
    private val eventDao: EventDao
) : IEventStorage {
    override suspend fun getEvents(): List<EventEntity> {
        val aux = eventDao.getEvents()
        return aux
    }

    override suspend fun addEvents(list: EventsDto) {
        eventDao.deleteAll()
        eventDao.addEvents(list.events.map { it.toEntity() })
    }
}
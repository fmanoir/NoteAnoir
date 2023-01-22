package com.anoirdev.test.data.source.local.storage

import com.anoirdev.test.data.repositories.event.IEventStorage
import com.anoirdev.test.data.source.local.dao.EventDao
import com.anoirdev.test.data.source.local.entity.EventEntity
import javax.inject.Inject


/*
Event Storage = DAO
 */

class EventStorage @Inject constructor(
    private val eventDao: EventDao
) : IEventStorage {
    override suspend fun getEvents(): List<EventEntity> {
        return eventDao.getEvents()
    }

    override suspend fun addEvents(list: List<EventEntity>) {
        eventDao.addEvents(list)
    }
}
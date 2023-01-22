package com.anoir.noteanoir.data.source.local.storage

import com.anoir.noteanoir.data.repositories.note.IEventStorage
import com.anoir.noteanoir.data.source.local.dao.EventDao
import com.anoir.noteanoir.data.source.local.entity.EventEntity
import javax.inject.Inject


/*
Event Storage = DAO and Repo
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
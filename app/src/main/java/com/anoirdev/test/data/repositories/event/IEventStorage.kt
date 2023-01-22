package com.anoirdev.test.data.repositories.event

import com.anoirdev.test.data.source.local.entity.EventEntity

/*
Event Storage interface
 */

interface IEventStorage {
    suspend fun getEvents(): List<EventEntity>
    suspend fun addEvents(list: List<EventEntity>)
}
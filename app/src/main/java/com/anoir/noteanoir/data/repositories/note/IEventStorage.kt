package com.anoir.noteanoir.data.repositories.note

import com.anoir.noteanoir.data.source.local.entity.EventEntity

/*
Note Storage interface
 */

interface IEventStorage {
    suspend fun getEvents(): List<EventEntity>
    suspend fun addEvents(list:List<EventEntity>)
}
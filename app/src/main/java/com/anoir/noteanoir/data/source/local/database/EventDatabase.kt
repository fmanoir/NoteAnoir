package com.anoir.noteanoir.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anoir.noteanoir.data.common.DATABASE_VERSION
import com.anoir.noteanoir.data.source.local.dao.EventDao
import com.anoir.noteanoir.data.source.local.entity.EventEntity

/*
Database of application + DAO instances
 */
@Database(
    entities = [EventEntity::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class EventDatabase : RoomDatabase() {
    abstract val eventDao: EventDao
}


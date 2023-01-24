package com.anoirdev.test.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anoirdev.test.data.source.local.dao.EventDao
import com.anoirdev.test.data.source.local.entity.EventEntity
import com.anoirdev.test.utlis.DATABASE_VERSION
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


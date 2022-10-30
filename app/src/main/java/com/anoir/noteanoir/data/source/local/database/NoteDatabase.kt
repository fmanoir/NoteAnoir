package com.anoir.noteanoir.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.anoir.noteanoir.data.common.DATABASE_VERSION
import com.anoir.noteanoir.data.source.local.dao.NoteDao
import com.anoir.noteanoir.data.source.local.entity.NoteEntity

/*
Database of application + DAO instances
 */
@Database(
    entities = [NoteEntity::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao
}


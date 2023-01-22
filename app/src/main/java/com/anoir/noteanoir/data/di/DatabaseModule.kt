package com.anoir.noteanoir.data.di

import android.app.Application
import androidx.room.Room
import com.anoir.noteanoir.BuildConfig
import com.anoir.noteanoir.data.common.DATABASE_NAME
import com.anoir.noteanoir.data.repositories.note.IEventStorage
import com.anoir.noteanoir.data.source.local.dao.EventDao
import com.anoir.noteanoir.data.source.local.database.EventDatabase
import com.anoir.noteanoir.data.source.local.storage.EventStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
DI => DataBase/Storage/DAO
 */

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    // DataBase
    @Provides
    @Singleton
    fun providesDatabase(app: Application): EventDatabase =
        Room.databaseBuilder(app, EventDatabase::class.java, DATABASE_NAME)
            .apply {
                if (BuildConfig.DEBUG) fallbackToDestructiveMigration()
            }.build()

    // Storage
    @Provides
    @Singleton
    fun providesNoteStorage(
        eventDao: EventDao
    ): IEventStorage =
        EventStorage(eventDao = eventDao)

    // Dao
    @Provides
    @Singleton
    fun providesNoteDao(database: EventDatabase): EventDao {
        return database.eventDao
    }
}
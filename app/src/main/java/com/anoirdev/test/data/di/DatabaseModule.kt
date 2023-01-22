package com.anoirdev.test.data.di

import android.app.Application
import androidx.room.Room
import com.anoirdev.test.BuildConfig
import com.anoirdev.test.data.repositories.event.IEventStorage
import com.anoirdev.test.data.source.local.dao.EventDao
import com.anoirdev.test.data.source.local.database.EventDatabase
import com.anoirdev.test.data.source.local.storage.EventStorage
import com.anoirdev.test.utlis.DATABASE_NAME
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
    fun providesEventStorage(
        eventDao: EventDao
    ): IEventStorage =
        EventStorage(eventDao = eventDao)

    // Dao
    @Provides
    @Singleton
    fun providesEventDao(database: EventDatabase): EventDao {
        return database.eventDao
    }
}
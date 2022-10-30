package com.anoir.noteanoir.core.di

import android.app.Application
import androidx.room.Room
import com.anoir.noteanoir.BuildConfig
import com.anoir.noteanoir.core.common.DATABASE_NAME
import com.anoir.noteanoir.data.repositories.note.INoteStorage
import com.anoir.noteanoir.data.source.local.dao.NoteDao
import com.anoir.noteanoir.data.source.local.database.NoteDatabase
import com.anoir.noteanoir.data.source.local.storage.NoteStorage
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

    @Provides
    @Singleton
    fun providesDatabase(app: Application): NoteDatabase =
        Room.databaseBuilder(app, NoteDatabase::class.java, DATABASE_NAME)
            .apply {
                if (BuildConfig.DEBUG) fallbackToDestructiveMigration()
            }.build()

    @Provides
    @Singleton
    fun providesNoteStorage(
        noteDao: NoteDao
    ): INoteStorage =
        NoteStorage(noteDao = noteDao)



    @Provides
    @Singleton
    fun providesNoteDao(database: NoteDatabase): NoteDao {
        return database.noteDao
    }
}
package com.anoir.noteanoir.data.di

import com.anoir.noteanoir.data.repositories.note.IEventService
import com.anoir.noteanoir.data.repositories.note.IEventStorage
import com.anoir.noteanoir.data.repositories.note.EventRepository
import com.anoir.noteanoir.domain.repository.IEventRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

/*
Repository with service or/and storage DI
 */

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Provides
    @Singleton
    fun provideNoteRepository (
        eventStorage: IEventStorage,
        eventService: IEventService
    ): IEventRepository =
        EventRepository (eventStorage = eventStorage,eventService = eventService)


}
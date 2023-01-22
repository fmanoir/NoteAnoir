package com.anoirdev.test.data.di

import com.anoirdev.test.data.repositories.event.EventRepository
import com.anoirdev.test.data.repositories.event.IEventService
import com.anoirdev.test.data.repositories.event.IEventStorage
import com.anoirdev.test.domain.repository.IEventRepository
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
    fun provideEventRepository(
        eventStorage: IEventStorage,
        eventService: IEventService
    ): IEventRepository =
        EventRepository(eventStorage = eventStorage, eventService = eventService)


}
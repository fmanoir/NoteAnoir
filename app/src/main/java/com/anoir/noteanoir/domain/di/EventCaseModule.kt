package com.anoir.noteanoir.domain.di

import com.anoir.noteanoir.domain.repository.IEventRepository
import com.anoir.noteanoir.domain.usecase.GetEvents
import com.anoir.noteanoir.domain.usecase.EventUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
NoteCase DI
 */

@Module
@InstallIn(SingletonComponent::class)
class EventCaseModule {

    @Provides
    @Singleton
    fun providesGetEvents(
        eventRepository: IEventRepository
    ): EventUseCase.IGetEvents =
        GetEvents(eventRepository = eventRepository)

}
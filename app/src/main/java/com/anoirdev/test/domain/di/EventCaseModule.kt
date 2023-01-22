package com.anoirdev.test.domain.di

import com.anoirdev.test.domain.repository.IEventRepository
import com.anoirdev.test.domain.usecase.EventUseCase
import com.anoirdev.test.domain.usecase.GetEvents
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
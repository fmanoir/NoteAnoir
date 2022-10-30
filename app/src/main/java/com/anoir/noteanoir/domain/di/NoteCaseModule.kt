package com.anoir.noteanoir.domain.di

import com.anoir.noteanoir.domain.repository.INoteRepository
import com.anoir.noteanoir.domain.usecase.GetAllNote
import com.anoir.noteanoir.domain.usecase.NoteUseCase
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
class NoteCaseModule {

    @Provides
    @Singleton
    fun providesGetAllNote(
        noteRepository: INoteRepository
    ): NoteUseCase.IGetAllNote =
        GetAllNote(noteRepository = noteRepository)

}
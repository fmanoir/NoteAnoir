package com.anoir.noteanoir.data.di

import com.anoir.noteanoir.data.repositories.note.INoteStorage
import com.anoir.noteanoir.data.repositories.note.NoteRepository
import com.anoir.noteanoir.domain.repository.INoteRepository
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
        noteStorage: INoteStorage
    ): INoteRepository =
        NoteRepository (noteStorage = noteStorage)


}
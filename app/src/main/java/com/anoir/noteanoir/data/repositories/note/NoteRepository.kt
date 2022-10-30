package com.anoir.noteanoir.data.repositories.note

import com.anoir.noteanoir.data.common.IFetchingStrategy
import com.anoir.noteanoir.data.source.mappers.toData
import com.anoir.noteanoir.data.source.mappers.toDomain
import com.anoir.noteanoir.data.source.mappers.toEntity
import com.anoir.noteanoir.domain.model.NoteDomain
import com.anoir.noteanoir.domain.repository.INoteRepository
import com.anoir.noteanoir.utlis.sealed.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

/*
Note Repository
 */

@ExperimentalCoroutinesApi
class NoteRepository @Inject constructor(
    private val noteStorage: INoteStorage,
    private val noteService: INoteService
) : INoteRepository, IFetchingStrategy {
    override suspend fun getAllNote(): Flow<Resource<List<NoteDomain>>> {
        return fetching(
            shouldFetchFromRemote = { flowOf(true) },
            fetchFromRemote = {
                noteService.getAllNote()
            },
            saveRemoteData = { listNoteFromRemote -> listNoteFromRemote.map { noteStorage.addNote(it.toEntity()) }},
            fetchFromLocal = { flowOf(noteStorage.getAllNote().map { it.toDomain() }) }
        )
    }

    override suspend fun addNote(note: NoteDomain) {
        noteStorage.addNote(note.toData())
    }

}
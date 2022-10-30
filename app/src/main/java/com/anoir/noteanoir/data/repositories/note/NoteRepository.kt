package com.anoir.noteanoir.data.repositories.note

import com.anoir.noteanoir.data.source.mappers.toData
import com.anoir.noteanoir.data.source.mappers.toDomain
import com.anoir.noteanoir.domain.model.NoteDomain
import com.anoir.noteanoir.domain.repository.INoteRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

/*
Note Repository
 */

@ExperimentalCoroutinesApi
class NoteRepository @Inject constructor(
    private val noteStorage: INoteStorage
) : INoteRepository {
    override suspend fun getAllNote(): List<NoteDomain> {
        return noteStorage.getAllNote().map { it.toDomain() }
    }

    override suspend fun insertNote(note: NoteDomain) {
        noteStorage.insertNote(note.toData())
    }

}
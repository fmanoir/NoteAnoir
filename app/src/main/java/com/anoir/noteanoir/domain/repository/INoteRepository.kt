package com.anoir.noteanoir.domain.repository

import com.anoir.noteanoir.domain.model.NoteModel
import com.anoir.noteanoir.utlis.sealed.Resource
import kotlinx.coroutines.flow.Flow

/*
Interface Repository Note
 */

interface INoteRepository {
    suspend fun getAllNote(): Flow<Resource<List<NoteModel>>>
    suspend fun addNote(note: NoteModel)
}
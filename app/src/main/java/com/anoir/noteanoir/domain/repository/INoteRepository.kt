package com.anoir.noteanoir.domain.repository

import com.anoir.noteanoir.domain.model.NoteDomain
import com.anoir.noteanoir.utlis.sealed.Resource
import kotlinx.coroutines.flow.Flow

/*
Interface Repository Note
 */

interface INoteRepository {
    suspend fun getAllNote(): Flow<Resource<List<NoteDomain>>>
    suspend fun addNote(note: NoteDomain)
}
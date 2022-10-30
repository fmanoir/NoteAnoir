package com.anoir.noteanoir.data.repositories.note

import com.anoir.noteanoir.data.source.remote.dto.NoteDto
import com.anoir.noteanoir.utlis.sealed.Resource
import kotlinx.coroutines.flow.Flow
/*
Note Service interface
 */

interface INoteService {
    suspend fun getAllNote(): Flow<Resource<List<NoteDto>>>
}
package com.anoir.noteanoir.domain.repository

import com.anoir.noteanoir.domain.model.NoteDomain
/*
Interface Repository Note
 */

interface INoteRepository {
    suspend fun getAllNote(): List<NoteDomain>
    suspend fun insertNote(note: NoteDomain)
}
package com.anoir.noteanoir.data.repositories.note

import com.anoir.noteanoir.data.source.local.entity.NoteEntity

/*
Note Storage interface
 */

interface INoteStorage {
    suspend fun getAllNote(): List<NoteEntity>
    suspend fun addNote(note: NoteEntity)
}
package com.anoir.noteanoir.data.source.local.storage

import com.anoir.noteanoir.data.repositories.note.INoteStorage
import com.anoir.noteanoir.data.source.local.dao.NoteDao
import com.anoir.noteanoir.data.source.local.entity.NoteEntity
import javax.inject.Inject


/*
Note Storage = DAO and Repositorie
 */

class NoteStorage @Inject constructor(
    private val noteDao: NoteDao
) : INoteStorage {
    override suspend fun getAllNote(): List<NoteEntity> {
        return noteDao.getAllNote()
    }

    override suspend fun addNote(note: NoteEntity) {
        noteDao.addNote(note)
    }
}
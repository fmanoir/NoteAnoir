package com.anoir.noteanoir.domain.usecase

import com.anoir.noteanoir.domain.model.NoteModel
import com.anoir.noteanoir.domain.repository.INoteRepository
import javax.inject.Inject

/*
US to add note
 */

class AddNote @Inject constructor(private val noteRepository: INoteRepository) :
    NoteUseCase.IAddNote {

    override suspend fun invoke(input: NoteModel) {
        noteRepository.addNote(input)
    }
}
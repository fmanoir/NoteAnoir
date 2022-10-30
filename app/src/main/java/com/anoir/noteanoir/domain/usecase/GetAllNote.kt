package com.anoir.noteanoir.domain.usecase

import com.anoir.noteanoir.domain.model.NoteDomain
import com.anoir.noteanoir.domain.repository.INoteRepository
import javax.inject.Inject

/*
US to get all note
 */

class GetAllNote @Inject constructor(private val noteRepository: INoteRepository) :
    NoteUseCase.IGetAllNote {

    override suspend fun invoke(): List<NoteDomain> {
        return noteRepository.getAllNote()
    }
}
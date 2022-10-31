package com.anoir.noteanoir.domain.usecase

import com.anoir.noteanoir.domain.model.NoteDomain
import com.anoir.noteanoir.domain.repository.INoteRepository
import com.anoir.noteanoir.utlis.sealed.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/*
US to get all note
 */

class GetAllNote @Inject constructor(private val noteRepository: INoteRepository) :
    NoteUseCase.IGetAllNote {

    override suspend fun invoke(): Flow<Resource<List<NoteDomain>>> {
        return noteRepository.getAllNote()
    }
}
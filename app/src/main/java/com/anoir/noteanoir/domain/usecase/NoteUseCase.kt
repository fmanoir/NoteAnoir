package com.anoir.noteanoir.domain.usecase

import com.anoir.noteanoir.domain.common.IUseCase
import com.anoir.noteanoir.domain.model.NoteModel
import com.anoir.noteanoir.utlis.sealed.Resource
import kotlinx.coroutines.flow.Flow


object NoteUseCase {
    interface IGetAllNote : IUseCase.Suspended.Output<Flow<Resource<List<NoteModel>>>>
    interface IAddNote : IUseCase.Suspended.Input<NoteModel>

}
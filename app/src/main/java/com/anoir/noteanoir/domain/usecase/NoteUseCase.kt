package com.anoir.noteanoir.domain.usecase

import com.anoir.noteanoir.domain.common.IUseCase
import com.anoir.noteanoir.domain.model.NoteDomain


object NoteUseCase {
    interface IGetAllNote : IUseCase.Suspended.Output<List<NoteDomain>>
    interface IAddNote : IUseCase.Suspended.Input<NoteDomain>

}
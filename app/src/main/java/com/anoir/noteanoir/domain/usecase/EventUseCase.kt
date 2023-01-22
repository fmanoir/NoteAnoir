package com.anoir.noteanoir.domain.usecase

import com.anoir.noteanoir.domain.common.IUseCase
import com.anoir.noteanoir.domain.model.EventModel
import com.anoir.noteanoir.utlis.sealed.Resource
import kotlinx.coroutines.flow.Flow


object EventUseCase {
    interface IGetEvents : IUseCase.Suspended.Output<Flow<Resource<List<EventModel>>>>

}
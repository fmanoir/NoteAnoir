package com.anoirdev.test.domain.usecase

import com.anoirdev.test.domain.common.IUseCase
import com.anoirdev.test.domain.model.EventModel
import com.anoirdev.test.utlis.sealed.Resource
import kotlinx.coroutines.flow.Flow


object EventUseCase {
    interface IGetEvents : IUseCase.Suspended.Output<Flow<Resource<List<EventModel>>>>

}
package com.anoir.noteanoir.data.source.remote.common.error

import com.anoir.noteanoir.utlis.sealed.ErrorFailure
import javax.inject.Inject

/*
Handler Error
 */

class ApiErrorHandler @Inject constructor() : IApiErrorHandler {
    override fun getError(error: Throwable): ErrorFailure {
        return ErrorFailure.Connection.TryLater
    }
}
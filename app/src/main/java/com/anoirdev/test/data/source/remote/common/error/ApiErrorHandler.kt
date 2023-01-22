package com.anoirdev.test.data.source.remote.common.error

import com.anoirdev.test.utlis.sealed.Failure
import javax.inject.Inject

/*
Handler Error
 */

class ApiErrorHandler @Inject constructor() : IApiErrorHandler {
    override fun getError(error: Throwable): Failure {
        return Failure.Connection.TryLater
    }
}
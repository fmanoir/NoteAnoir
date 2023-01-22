package com.anoirdev.test.data.source.remote.common.error

import com.anoirdev.test.utlis.sealed.Failure


interface IApiErrorHandler {
    fun getError(error: Throwable): Failure
}
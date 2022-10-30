package com.anoir.noteanoir.data.source.remote.common.error

import com.anoir.noteanoir.utlis.sealed.ErrorFailure


interface IApiErrorHandler {
    fun getError(error: Throwable): ErrorFailure
}
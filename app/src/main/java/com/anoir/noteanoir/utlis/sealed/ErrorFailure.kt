package com.anoir.noteanoir.utlis.sealed

/*
Failure API Sealed Type
 */

sealed class ErrorFailure {
    sealed class Connection {
        object Unavailable : ErrorFailure()
        object NoBody : ErrorFailure()
        object TryLater : ErrorFailure()
    }
}
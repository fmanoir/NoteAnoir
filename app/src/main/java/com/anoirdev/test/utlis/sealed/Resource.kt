package com.anoirdev.test.utlis.sealed


/*
Resource Sealed Type
 */

sealed class Resource<out T : Any> {
    data class OnSuccess<out T : Any>(val data: T) : Resource<T>()
    data class OnFailed(val failure: Failure) : Resource<Nothing>()
}

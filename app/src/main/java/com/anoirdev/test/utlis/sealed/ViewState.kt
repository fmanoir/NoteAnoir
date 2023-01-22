package com.anoirdev.test.utlis.sealed

sealed class ViewState<out T : Any> {
    data class Loading(val isLoading: Boolean) : ViewState<Nothing>()
    data class RenderSuccess<out T : Any>(val output: T) : ViewState<T>()
    data class RenderFailure(val failure: Failure) : ViewState<Nothing>()
}
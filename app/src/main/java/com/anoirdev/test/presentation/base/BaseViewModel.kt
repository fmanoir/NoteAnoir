package com.anoirdev.test.presentation.base

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anoirdev.test.utlis.IViewStateFlow
import com.anoirdev.test.utlis.resource.IResourceProvider
import kotlinx.coroutines.launch

abstract class BaseViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val resourcesProvider: IResourceProvider,
) : ViewModel(), IViewStateFlow {

    fun execute(work: suspend () -> Unit) =
        viewModelScope.launch {
            work()
        }
}
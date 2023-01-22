package com.anoirdev.test.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anoirdev.test.utlis.helper.IViewStateFlow
import com.anoirdev.test.utlis.helper.SingleLiveEvent
import com.anoirdev.test.utlis.resource.IResourceProvider
import kotlinx.coroutines.launch

abstract class BaseViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val resourcesProvider: IResourceProvider,
) : ViewModel(), IViewStateFlow {

    //for displaying global snack bar
    private val _snackBarMessage: SingleLiveEvent<String> = SingleLiveEvent()
    val snackBarMessage: LiveData<String>
        get() = _snackBarMessage

    /**
     * Show snack bar.
     */
    protected fun shownSnackBarMessage(message: String) {
        _snackBarMessage.value = message
    }

    fun execute(work: suspend () -> Unit) =
        viewModelScope.launch {
            work()
        }
}
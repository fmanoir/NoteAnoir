package com.anoirdev.test.presentation.xml

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.anoirdev.test.domain.model.EventModel
import com.anoirdev.test.domain.usecase.EventUseCase
import com.anoirdev.test.presentation.base.BaseViewModel
import com.anoirdev.test.utlis.resource.IResourceProvider
import com.anoirdev.test.utlis.sealed.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.grdf.app.android.olm.core.utils.IDispatcherProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
@HiltViewModel
class XMLViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val getEvents: EventUseCase.IGetEvents,
    private val dispatcherProvider: IDispatcherProvider,
    resourceProvider: IResourceProvider,
) : BaseViewModel(savedStateHandle, resourceProvider) {


    private val _observableDataEvent = MutableLiveData(EventUI())
    val observableDataEvent: LiveData<EventUI> = _observableDataEvent

    init {
        execute {
            viewStateFlow(dispatcherProvider) {
                getEvents()
            }.collect {
                when (it) {
                    is ViewState.Loading -> it.isLoading
                    is ViewState.RenderFailure -> {
                    }
                    is ViewState.RenderSuccess<List<EventModel>> -> renderBindDataSuccess(it.output)
                }
            }
        }
    }

    private fun renderBindDataSuccess(list: List<EventModel>) {
        _observableDataEvent.postValue(
            EventUI(
                visibilityOfList = View.VISIBLE,
                listOfData = list.map { it.toPresentation() }
            )
        )
    }

    data class EventUI(
        val listOfData: List<EventPresentation> = emptyList(),
        val visibilityOfList: Int = View.GONE,
    )
}
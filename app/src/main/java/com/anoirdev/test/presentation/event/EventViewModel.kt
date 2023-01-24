package com.anoirdev.test.presentation.event

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.anoirdev.test.R
import com.anoirdev.test.domain.model.EventModel
import com.anoirdev.test.domain.usecase.EventUseCase
import com.anoirdev.test.presentation.base.BaseViewModel
import com.anoirdev.test.presentation.mappers.toPresentation
import com.anoirdev.test.utlis.dispatcher.IDispatcherProvider
import com.anoirdev.test.utlis.resource.IResourceProvider
import com.anoirdev.test.utlis.sealed.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
@HiltViewModel
class EventViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val getEvents: EventUseCase.IGetEvents,
    private val dispatcherProvider: IDispatcherProvider,
    private val resourceProvider: IResourceProvider,
) : BaseViewModel(savedStateHandle, resourceProvider) {


    private val _observableDataEvent = MutableLiveData(EventUI())
    val observableDataEvent: LiveData<EventUI> = _observableDataEvent

    init {
        loadData()
    }

    fun loadData() {
        execute {
            viewStateFlow(dispatcherProvider) {
                getEvents()
            }.collect {
                when (it) {
                    is ViewState.Loading -> it.isLoading
                    is ViewState.RenderFailure -> {
                        shownSnackBarMessage(resourceProvider.getString(R.string.try_later))
                    }
                    is ViewState.RenderSuccess<List<EventModel>> -> renderBindDataSuccess(it.output)
                }
            }
        }
    }

    private fun renderBindDataSuccess(list: List<EventModel>) {
        _observableDataEvent.postValue(
            EventUI(
                visibilityOfIndicator = View.GONE,
                listOfData = list.map { it.toPresentation() }
            )
        )
    }

    data class EventUI(
        val listOfData: List<EventPresentation> = emptyList(),
        val visibilityOfIndicator: Int = View.VISIBLE,
    )
}
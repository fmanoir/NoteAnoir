package com.anoirdev.test.presentation.event

import android.view.View
import androidx.lifecycle.SavedStateHandle
import com.anoirdev.test.builder.BuilderEvent
import com.anoirdev.test.domain.usecase.EventUseCase
import com.anoirdev.test.presentation.base.BaseTestViewModel
import com.anoirdev.test.utlis.sealed.Resource
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import junitparams.JUnitParamsRunner
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class EventViewModelTest : BaseTestViewModel() {


    private lateinit var savedStateHandle: SavedStateHandle
    private lateinit var viewModel: EventViewModel

    @RelaxedMockK
    lateinit var getEvents: EventUseCase.IGetEvents

    @Before
    override fun setUp() {
        super.setUp()

        savedStateHandle = SavedStateHandle()
        viewModel = EventViewModel(
            getEvents = getEvents,
            savedStateHandle = savedStateHandle,
            dispatcherProvider = dispatcherProvider,
            resourceProvider = resources
        )
        baseViewModel = viewModel
    }


    @Test
    fun `when onLoad should call getEvents and return the right EventUI`() {
        coroutineRule.runBlockingTest {
            coEvery { getEvents() } returns flowOf(
                Resource.OnSuccess(listOf(BuilderEvent.BUILD_EVENT_MODEL))
            )
            viewModel.loadData()
            with(viewModel.observableDataEvent.value!!) {
                assertEquals(listOfData.size, 1)
                assertEquals(visibilityOfIndicator, View.GONE)
                assertEquals(listOfData[0], BuilderEvent.BUILD_EVENT_PRESENTATION)

            }
        }
    }
}
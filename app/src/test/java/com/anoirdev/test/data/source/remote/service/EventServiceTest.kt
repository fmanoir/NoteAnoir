package com.anoirdev.test.data.source.remote.service

import com.anoirdev.test.builder.BuilderEvent.Companion.BUILD_EVENT_DTO
import com.anoirdev.test.data.source.remote.api.EventAPI
import com.anoirdev.test.data.source.remote.common.error.ApiErrorHandler
import com.anoirdev.test.data.source.remote.common.network.InternetStatusInterface
import com.anoirdev.test.data.source.remote.common.network.InternetStatusType
import com.anoirdev.test.utlis.sealed.Failure
import com.anoirdev.test.utlis.sealed.Resource
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Response


@ExperimentalCoroutinesApi
class EventServiceTest {

    @MockK
    lateinit var eventAPI: EventAPI

    @MockK
    lateinit var internetStatusInterface: InternetStatusInterface


    private lateinit var eventService: EventService


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        eventService = EventService(
            eventAPI = eventAPI,
            apiErrorHandler = ApiErrorHandler(),
            internetStatusInterface = internetStatusInterface
        )
    }

    @Test
    fun `when internet not available during getEvents from eventAPI should return the Failure `() =
        runBlockingTest {
            every { internetStatusInterface.ping() } returns flow { emit(InternetStatusType.NO_INTERNET) }
            val result = eventService.getEvents().single()
            coVerify(exactly = 0) { eventAPI.getEvents() }
            assertEquals(Resource.OnFailed(Failure.Connection.Unavailable), result)
        }

    @Test
    fun `when internet available during getEvents from eventAPI should return the right Resource `() =
        runBlockingTest {
            every { internetStatusInterface.ping() } returns flow { emit(InternetStatusType.INTERNET) }
            coEvery { eventAPI.getEvents() } returns Response.success(BUILD_EVENT_DTO)
            val result = eventService.getEvents().single()
            coVerify(exactly = 1) { eventAPI.getEvents() }
            assertEquals(Resource.OnSuccess(listOf(BUILD_EVENT_DTO)), result)
        }

}
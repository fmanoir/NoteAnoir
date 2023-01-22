package com.anoirdev.test.data.repositories.event

import com.anoirdev.test.builder.BuilderEvent.Companion.BUILD_EVENT_DTO
import com.anoirdev.test.builder.BuilderEvent.Companion.BUILD_EVENT_ENTITY
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import junitparams.JUnitParamsRunner
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Response


@ExperimentalCoroutinesApi
@RunWith(JUnitParamsRunner::class)
class EventRepositoryTest {

    @RelaxedMockK
    private lateinit var eventStorage: IEventStorage

    @RelaxedMockK
    private lateinit var eventService: IEventService

    @InjectMockKs
    private lateinit var eventRepository: EventRepository


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `should run eventStorage to get all events`() {
        runBlockingTest {
            coEvery { eventStorage.getEvents() } returns listOf(BUILD_EVENT_ENTITY)
            coEvery { eventService.getEvents() } returns flow {
                Response.success(
                    listOf(
                        BUILD_EVENT_DTO
                    )
                )
            }
            val result = eventRepository.getEvents()
            coVerify(exactly = 1) { eventService.getEvents() }
            coVerify(exactly = 1) { eventService.getEvents() }
            assertEquals(result, listOf(BUILD_EVENT_ENTITY))
        }
    }
}
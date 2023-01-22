package com.anoirdev.test.domain.usecase

import com.anoirdev.test.builder.BuilderEvent.Companion.BUILD_EVENT_MODEL
import com.anoirdev.test.domain.repository.IEventRepository
import com.anoirdev.test.utlis.sealed.Resource
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


@ExperimentalCoroutinesApi
class GetEventsTest {
    @RelaxedMockK
    private lateinit var eventRepository: IEventRepository

    @InjectMockKs
    private lateinit var getEvents: GetEvents


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `should run eventRepository to get all events`() {
        runBlockingTest {
            coEvery { eventRepository.getEvents() } returns flowOf(
                Resource.OnSuccess(
                    listOf(BUILD_EVENT_MODEL)
                )
            )
            val result = getEvents().single()
            coVerify(exactly = 1) { eventRepository.getEvents() }
            assertEquals(
                Resource.OnSuccess(listOf(BUILD_EVENT_MODEL)),
                result
            )
        }
    }

}
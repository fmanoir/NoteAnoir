package com.anoir.noteanoir.data.source.remote.service

import com.anoir.noteanoir.data.source.builder.NoteBuilder.Companion.BUILD_NOTE_DTO
import com.anoir.noteanoir.data.source.remote.api.NoteAPI
import com.anoir.noteanoir.data.source.remote.common.error.ApiErrorHandler
import com.anoir.noteanoir.data.source.remote.common.network.InternetStatusInterface
import com.anoir.noteanoir.data.source.remote.common.network.InternetStatusType
import com.anoir.noteanoir.utlis.sealed.ErrorFailure
import com.anoir.noteanoir.utlis.sealed.Resource
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
class NoteServiceTest {

    @MockK
    lateinit var noteAPI: NoteAPI

    @MockK
    lateinit var internetStatusInterface: InternetStatusInterface


    private lateinit var noteService: NoteService


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        noteService = NoteService(
            noteAPI = noteAPI,
            apiErrorHandler = ApiErrorHandler(),
            internetStatusInterface = internetStatusInterface
        )
    }

    @Test
    fun `when internet not available during getAllNote from note API should return the Failure `() =
        runBlockingTest {
            every { internetStatusInterface.ping() } returns flow { emit(InternetStatusType.NO_INTERNET) }
            val result = noteService.getAllNote().single()
            coVerify(exactly = 0) { noteAPI.getAllNote() }
            assertEquals(Resource.OnFailed(ErrorFailure.Connection.Unavailable), result)
        }

    @Test
    fun `when internet available during getAllNote from note API should return the right Resource `() =
        runBlockingTest {
            every { internetStatusInterface.ping() } returns flow { emit(InternetStatusType.INTERNET) }
            coEvery {noteAPI.getAllNote() } returns Response.success(listOf(BUILD_NOTE_DTO))
            val result =noteService.getAllNote().single()
            assertEquals(Resource.OnSuccess(listOf(BUILD_NOTE_DTO)), result)
        }

}
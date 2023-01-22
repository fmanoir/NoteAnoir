package com.anoir.noteanoir.data.source.local.storage

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.anoir.noteanoir.data.repositories.note.IEventStorage
import com.anoir.noteanoir.data.source.builder.NoteBuilder
import com.anoir.noteanoir.data.source.local.dao.EventDao
import com.anoir.noteanoir.data.source.local.database.EventDatabase
import com.anoir.noteanoir.domain.model.EventModel
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@HiltAndroidTest
class EventStorageTest {

    @MockK
    private lateinit var noteStorage: IEventStorage

    lateinit var database: EventDatabase

    lateinit var eventDao: EventDao

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().context
        database = Room.inMemoryDatabaseBuilder(context, EventDatabase::class.java)
            .allowMainThreadQueries().build()
        eventDao = database.eventDao
        MockKAnnotations.init(this)
        noteStorage = EventStorage(
            eventDao = eventDao,
        )
    }

    @Test
    fun shouldReturnsAllNote_WhenExist() {
        runBlocking {
            noteStorage.addEvents(NoteBuilder.BUILD_NOTE_ENTITY)
            val result = noteStorage.getEvents()
            assertEquals(1, result.size)
            assertEquals(NoteBuilder.PARAMETER_NOTE_ID, result[0].id)
            assertEquals(NoteBuilder.PARAMETER_NOTE_TITLE, result[0].title)
        }
    }

    @Test
    fun shouldReturnEmptyList_WhenNoNote() {
        runBlocking {
            assertEquals(emptyList<EventModel>(), noteStorage.getEvents())
        }
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        database.close()
    }


}


package com.anoirdev.test.data.source.local.storage

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.anoirdev.test.builder.BuilderEvent
import com.anoirdev.test.data.repositories.event.IEventStorage
import com.anoirdev.test.data.source.local.dao.EventDao
import com.anoirdev.test.data.source.local.database.EventDatabase
import com.anoirdev.test.domain.model.EventModel
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

    private lateinit var database: EventDatabase

    private lateinit var eventDao: EventDao

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
    fun shouldReturnEvents_WhenExist() {
        runBlocking {
            noteStorage.addEvents(listOf(BuilderEvent.BUILD_EVENT_ENTITY))
            val result = noteStorage.getEvents()
            assertEquals(1, result.size)
            assertEquals(BuilderEvent.BUILD_EVENT_ENTITY, result[0])
        }
    }

    @Test
    fun shouldReturnEmptyList_WhenNoData() {
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


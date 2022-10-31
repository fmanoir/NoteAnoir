package com.anoir.noteanoir.data.source.local.storage

import androidx.annotation.CallSuper
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.anoir.noteanoir.data.repositories.note.INoteStorage
import com.anoir.noteanoir.data.source.build.NoteBuilder
import com.anoir.noteanoir.data.source.local.dao.NoteDao
import com.anoir.noteanoir.data.source.local.database.NoteDatabase
import com.anoir.noteanoir.domain.model.NoteDomain
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
class NoteStorageTest {

    @MockK
    private lateinit var noteStorage: INoteStorage

    lateinit var database: NoteDatabase

    lateinit var noteDao: NoteDao

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().context
        database = Room.inMemoryDatabaseBuilder(context, NoteDatabase::class.java)
            .allowMainThreadQueries().build()
        noteDao = database.noteDao
        MockKAnnotations.init(this)
        noteStorage = NoteStorage(
            noteDao = noteDao,
        )
    }

    @Test
    fun shouldReturnsAllNote_WhenExist() {
        runBlocking {
            noteStorage.addNote(NoteBuilder.BUILD_NOTE_ENTITY)
            val result = noteStorage.getAllNote()
            assertEquals(1, result.size)
            assertEquals(NoteBuilder.PARAMETER_NOTE_ID, result[0].id)
            assertEquals(NoteBuilder.PARAMETER_NOTE_TITLE, result[0].title)
        }
    }

    @Test
    fun shouldReturnEmptyList_WhenNoNote() {
        runBlocking {
            assertEquals(emptyList<NoteDomain>(), noteStorage.getAllNote())
        }
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        database.close()
    }


}


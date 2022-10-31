package com.anoir.noteanoir.data.source.local.storage

import com.anoir.noteanoir.data.repositories.note.INoteStorage
import com.anoir.noteanoir.data.source.local.entity.NoteEntity
import com.anoir.noteanoir.domain.model.NoteDomain
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@HiltAndroidTest
class NoteStorageTest : BaseStorageTest() {

    @MockK
    private lateinit var noteStorage: INoteStorage

    override fun setUp() {
        super.setUp()
        MockKAnnotations.init(this)
        noteStorage = NoteStorage(
            noteDao = noteDao,
        )
    }

    @Test
    fun shouldReturnsAllNote_WhenExist() {
        runBlocking {
            noteStorage.addNote(PARAMETER_ADD_NOTE)
            val result = noteStorage.getAllNote()
            assertEquals(1, result.size)
            assertEquals(PARAMETER_NOTE_ID, result[0].id)
            assertEquals(PARAMETER_NOTE_TITLE, result[0].title)
        }
    }

    @Test
    fun shouldReturnEmptyList_WhenNoNote() {
        runBlocking {
            assertEquals(emptyList<NoteDomain>(), noteStorage.getAllNote())
        }
    }


    companion object {
        private const val PARAMETER_NOTE_ID =1
        private const val PARAMETER_NOTE_TITLE ="accusamus beatae ad facilis cum similique qui sunt"
        private val PARAMETER_ADD_NOTE =
            NoteEntity(
                id =PARAMETER_NOTE_ID ,
                title = PARAMETER_NOTE_TITLE
            )
    }

}


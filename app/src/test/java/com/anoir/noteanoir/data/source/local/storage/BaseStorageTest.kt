package com.anoir.noteanoir.data.source.local.storage

import androidx.annotation.CallSuper
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.anoir.noteanoir.data.source.local.dao.NoteDao
import com.anoir.noteanoir.data.source.local.database.NoteDatabase
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.IOException

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@HiltAndroidTest
abstract class BaseStorageTest {

    lateinit var database: NoteDatabase

    protected lateinit var noteDao: NoteDao

    @Before
    @CallSuper
    open fun setUp() {
        val context = InstrumentationRegistry.getInstrumentation().context
        database = Room.inMemoryDatabaseBuilder(context, NoteDatabase::class.java)
            .allowMainThreadQueries().build()
        noteDao = database.noteDao
    }

    @After
    @Throws(IOException::class)
    fun tearDown() {
        database.close()
    }
}
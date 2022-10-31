package com.anoir.noteanoir.data.source.mappers

import com.anoir.noteanoir.data.source.build.NoteBuilder.Companion.BUILD_NOTE_DOMAIN
import com.anoir.noteanoir.data.source.build.NoteBuilder.Companion.BUILD_NOTE_ENTITY
import com.anoir.noteanoir.data.source.local.entity.NoteEntity
import com.anoir.noteanoir.data.source.local.storage.NoteStorageTest
import junitparams.JUnitParamsRunner
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(JUnitParamsRunner::class)
class ToDomainTest {

    @Test
    fun `should map NoteEntity to NoteDomain`() {
        val result = BUILD_NOTE_ENTITY.toDomain()
        assertEquals(
            BUILD_NOTE_DOMAIN, result
        )
    }


}
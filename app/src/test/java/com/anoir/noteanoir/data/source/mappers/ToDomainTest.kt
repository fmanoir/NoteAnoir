package com.anoir.noteanoir.data.source.mappers

import com.anoir.noteanoir.data.source.builder.NoteBuilder.Companion.BUILD_NOTE_MODEL
import com.anoir.noteanoir.data.source.builder.NoteBuilder.Companion.BUILD_NOTE_ENTITY
import junitparams.JUnitParamsRunner
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(JUnitParamsRunner::class)
class ToDomainTest {

    @Test
    fun `should map NoteEntity to NoteModel`() {
        val result = BUILD_NOTE_ENTITY.toModel()
        assertEquals(
            BUILD_NOTE_MODEL, result
        )
    }


}
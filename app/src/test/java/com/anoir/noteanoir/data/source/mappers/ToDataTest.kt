package com.anoir.noteanoir.data.source.mappers

import com.anoir.noteanoir.data.source.builder.NoteBuilder
import junitparams.JUnitParamsRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class ToDataTest {

    @Test
    fun `should map NoteDomain to NoteEntity`() {
        val result = NoteBuilder.BUILD_NOTE_MODEL.toData()
        Assert.assertEquals(
            NoteBuilder.BUILD_NOTE_ENTITY, result
        )
    }

}
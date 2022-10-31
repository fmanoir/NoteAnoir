package com.anoir.noteanoir.data.source.mappers

import com.anoir.noteanoir.data.source.build.NoteBuilder
import org.junit.Assert
import org.junit.Test

class DtoToEntityTest {

    @Test
    fun `should map NoteDto to NoteEntity`() {
        val result = NoteBuilder.BUILD_NOTE_DTO.toEntity()
        Assert.assertEquals(
            NoteBuilder.BUILD_NOTE_ENTITY, result
        )
    }


}
package com.anoir.noteanoir.data.source.builder

import com.anoir.noteanoir.data.source.local.entity.NoteEntity
import com.anoir.noteanoir.data.source.remote.dto.NoteDto
import com.anoir.noteanoir.domain.model.NoteModel

class NoteBuilder {

    companion object {

        const val PARAMETER_NOTE_ID = 1
        const val PARAMETER_NOTE_TITLE = "accusamus beatae ad facilis cum similique qui sunt"
        val BUILD_NOTE_ENTITY = NoteEntity(
            id = PARAMETER_NOTE_ID,
            title = PARAMETER_NOTE_TITLE
        )
        val BUILD_NOTE_DTO = NoteDto(
            id = PARAMETER_NOTE_ID,
            title = PARAMETER_NOTE_TITLE
        )
        val BUILD_NOTE_MODEL = NoteModel(
            id = PARAMETER_NOTE_ID,
            title = PARAMETER_NOTE_TITLE
        )
    }
}

package com.anoir.noteanoir.data.source.builder

import com.anoir.noteanoir.data.source.local.entity.EventEntity
import com.anoir.noteanoir.data.source.remote.dto.event.EventsDto
import com.anoir.noteanoir.domain.model.EventModel

class NoteBuilder {

    companion object {

        const val PARAMETER_NOTE_ID = 1
        const val PARAMETER_NOTE_TITLE = "accusamus beatae ad facilis cum similique qui sunt"
        val BUILD_NOTE_ENTITY = EventEntity(
            id = PARAMETER_NOTE_ID,
            title = PARAMETER_NOTE_TITLE
        )
        val BUILD_NOTE_DTO = EventsDto(
            id = PARAMETER_NOTE_ID,
            title = PARAMETER_NOTE_TITLE
        )
        val BUILD_NOTE_MODEL = EventModel(
            id = PARAMETER_NOTE_ID,
            title = PARAMETER_NOTE_TITLE
        )
    }
}

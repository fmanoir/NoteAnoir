package com.anoir.noteanoir.data.source.mappers

import com.anoir.noteanoir.data.source.local.entity.NoteEntity
import com.anoir.noteanoir.data.source.remote.dto.NoteDto


fun NoteDto.toEntity(): NoteEntity =
    NoteEntity(
        id = id,
        title = title
    )
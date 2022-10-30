package com.anoir.noteanoir.data.source.mappers

import com.anoir.noteanoir.data.source.local.entity.NoteEntity
import com.anoir.noteanoir.domain.model.NoteDomain


fun NoteDomain.toData(): NoteEntity =
    NoteEntity(
        id = id,
        title = title
    )
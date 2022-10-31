package com.anoir.noteanoir.data.source.mappers

import com.anoir.noteanoir.data.source.local.entity.NoteEntity
import com.anoir.noteanoir.domain.model.NoteModel

fun NoteEntity.toModel(): NoteModel =
    NoteModel(
        id = id,
        title = title
    )

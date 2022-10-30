package com.anoir.noteanoir.data.source.remote.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
Note Dto
 */
@Entity
data class NoteDto(
    @PrimaryKey
    val id: Int,
    val title: String
)
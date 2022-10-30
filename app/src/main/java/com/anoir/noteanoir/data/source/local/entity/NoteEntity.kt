package com.anoir.noteanoir.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/*
Note Entity
 */
@Entity
data class NoteEntity(
    @PrimaryKey
    val id: Int,
    val title: String
)
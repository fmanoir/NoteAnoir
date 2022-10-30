package com.anoir.noteanoir.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anoir.noteanoir.data.source.local.entity.NoteEntity

/*
Note Dao Interface
 */

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    @Query("select * from NoteEntity")
    fun getAllNote(): List<NoteEntity>
}
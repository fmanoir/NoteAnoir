package com.anoir.noteanoir.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.anoir.noteanoir.data.source.local.entity.EventEntity

/*
Note Dao Interface
 */

@Dao
interface EventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEvents(list: List<EventEntity>)

    @Query("select * from EventEntity")
    fun getEvents(): List<EventEntity>
}
package com.anoirdev.test.data.source.local.dao

import androidx.room.*
import com.anoirdev.test.data.source.local.entity.EventEntity

/*
Event Dao Interface
 */

@Dao
interface EventDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEvents(list: List<EventEntity>)

    @Query("DELETE FROM EventEntity")
    fun deleteAll()

    @Query("select * from EventEntity")
    fun getEvents(): List<EventEntity>
}
package com.molette.boondmanager.data.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(obj: T): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(obj: List<T?>): LongArray

    @Delete
    fun delete(obj: T)

    @Update
    fun update(obj: T)
}
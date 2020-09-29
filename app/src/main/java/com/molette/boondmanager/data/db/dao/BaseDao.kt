package com.molette.boondmanager.data.db.dao

import androidx.room.*

@Dao
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
package pl.kurczaczkowe.bills.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface BaseDao<T> {

    @Insert
    suspend fun insert(vararg t: T)

    @Insert
    suspend fun insertOne(t: T): Long

    @Insert
    suspend fun bulbInsert(list: List<T>)

    @Update
    suspend fun update(vararg t: T)

    @Delete
    suspend fun delete(vararg t: T)
}
package com.example.geminiai.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.geminiai.model.HistoryEntity

@Dao
interface DAO {
    @Insert
    fun insertHistory(historyEntity: HistoryEntity)
    @Query("SELECT * FROM history")
    fun readHistory():MutableList<HistoryEntity>
}
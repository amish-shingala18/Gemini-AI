package com.example.geminiai.helper

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.geminiai.interfaces.DAO
import com.example.geminiai.model.HistoryEntity

@Database(entities = [HistoryEntity::class], version = 1)
abstract class DbHelper : RoomDatabase() {
    abstract fun dao():DAO
    companion object{
        var db:DbHelper?=null
        fun initDb(context: Context):DbHelper{
            if (db==null){
                db=Room.databaseBuilder(context,
                    DbHelper::class.java,
                    "GeminiDb")
                    .allowMainThreadQueries()
                    .build()
            }
            return db!!
        }
    }
}
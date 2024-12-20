package com.example.demo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.demo.network.MarsPhoto

@Database(entities = [MarsPhoto::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MarsRoomDatabase:RoomDatabase() {
    abstract fun itemDao(): MarsDao
    //companion = static
    companion object{
        private var INSTANCE: MarsRoomDatabase? = null
        fun getDatabase(context : Context):MarsRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    MarsRoomDatabase::class.java,
                    "mars_database")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
        }
        }

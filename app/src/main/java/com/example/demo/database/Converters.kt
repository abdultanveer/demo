package com.example.demo.database

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromStringToInt(value: String): Int {
        return value.toInt()
    }

    @TypeConverter
    fun fromIntToString(value: Int): String {
        return value.toString()
    }
}

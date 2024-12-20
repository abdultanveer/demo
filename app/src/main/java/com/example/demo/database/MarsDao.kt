package com.example.demo.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.demo.network.MarsPhoto
import kotlinx.coroutines.flow.Flow

@Dao
interface MarsDao {
    @Insert
    suspend fun insert(marsPhoto: MarsPhoto)
    @Update
    suspend   fun update(photo: MarsPhoto)
    @Delete
    suspend fun delete(item: MarsPhoto)
    /*@Query("SELECT * from item WHERE id = :itemId")
    fun getItem(itemId: Int): Flow<Item>*/
    @Query("SELECT * from MarsPhoto ORDER BY imgSrc ASC")
    fun getItems(): Flow<List<MarsPhoto>>
}
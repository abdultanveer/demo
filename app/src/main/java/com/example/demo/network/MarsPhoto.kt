package com.example.demo.network

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

//pojo
@Entity
data class MarsPhoto(
    @PrimaryKey
    val  id:String,

    @Json(name = "img_src")
    val  imgSrc:String
)
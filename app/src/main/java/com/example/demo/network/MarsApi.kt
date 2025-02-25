package com.example.demo.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())//italian,covered
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi)) //to convert json to a pojo/vo/model
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService {
    @GET("photos")
   suspend fun getPhotos():List<MarsPhoto>

}
//by -- delegationn pattern
object MarsApi {
    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)

    }
}
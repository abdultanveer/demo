package com.example.demo

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.database.MarsDao
import com.example.demo.database.MarsRoomDatabase
import com.example.demo.network.MarsApi
import com.example.demo.network.MarsPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    var TAG = MainActivity::class.java.simpleName
    lateinit var dao: MarsDao

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        var database = MarsRoomDatabase.getDatabase(this)
        dao = database.itemDao()

    }

    fun getJson(view: View) {
        GlobalScope.launch(Dispatchers.Main) {
            getJsonnParse()
        }
    }

    private suspend fun getJsonnParse() {
        val id = MarsApi.retrofitService.getPhotos().get(0).id
        val imgUrl = MarsApi.retrofitService.getPhotos().get(0).imgSrc
      Log.i(TAG,"imgurl--"+imgUrl)
        textView.setText(imgUrl)
        dao.insert(MarsPhoto(id,imgUrl))



    }
}
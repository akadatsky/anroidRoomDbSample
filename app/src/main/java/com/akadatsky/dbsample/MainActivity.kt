package com.akadatsky.dbsample

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.akadatsky.dbsample.db.AppDatabase
import com.akadatsky.dbsample.db.User
import com.akadatsky.dbsample.db.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.OffsetDateTime

class MainActivity : AppCompatActivity() {

    lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "my-app-database"
        ).build()
        userDao = db.userDao()
    }

    fun save(view: View) {
        val alex = User("Alex", "A", OffsetDateTime.now())
        val ben = User("Ben", "B", OffsetDateTime.now())
        lifecycleScope.launch(Dispatchers.IO) {
            userDao.insertAll(alex, ben)
        }

    }

    fun load(view: View) {
        lifecycleScope.launch(Dispatchers.IO) {
            val users: List<User> = userDao.getAll()
            Log.i("asdfasdf", "$users")
        }
    }

    fun clear(view: View) {
        lifecycleScope.launch(Dispatchers.IO) {
            userDao.removeAll()
        }
    }
}
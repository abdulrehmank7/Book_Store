package com.arkapp.bookstore.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arkapp.bookstore.data.models.Book
import com.arkapp.bookstore.data.models.UserLogin

/**
 * Created by Abdul Rehman on 16-05-2020.
 * Contact email - abdulrehman0796@gmail.com
 */


@Database(entities = [Book::class, UserLogin::class], version = 1)
abstract class AppDatabase : RoomDatabase() {


    abstract fun booksDao(): BookDoa

    abstract fun userLoginDao(): UserLoginDao

    companion object {

        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, DATABASE_NAME
            ).build()
        }
    }
}
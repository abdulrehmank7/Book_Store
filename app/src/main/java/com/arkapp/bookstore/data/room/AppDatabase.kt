package com.arkapp.bookstore.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.arkapp.bookstore.data.models.Book
import com.arkapp.bookstore.data.models.UserLogin
import com.arkapp.bookstore.data.repository.BookRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by Abdul Rehman on 16-05-2020.
 * Contact email - abdulrehman0796@gmail.com
 */


@Database(entities = [Book::class, UserLogin::class], version = 1)
abstract class AppDatabase : RoomDatabase() {


    abstract fun booksDao(): BookDoa

    abstract fun userLoginDao(): UserLoginDao

    companion object {
        const val DATABASE_NAME = "MAIN_BOOK_DATABASE"

        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                )
                    .addCallback(AppDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    class AppDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.booksDao())
                }
            }
        }

        suspend fun populateDatabase(bookDoa: BookDoa) {
            // Delete all content here.
            bookDoa.deleteAll()

            val allBooks = BookRepository().getAllBooks()
            allBooks.forEach { book ->
                println("insert ${book.title}")
                bookDoa.insert(book)
            }
        }
    }
}
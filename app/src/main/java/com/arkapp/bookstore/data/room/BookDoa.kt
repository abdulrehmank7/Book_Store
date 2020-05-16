package com.arkapp.bookstore.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arkapp.bookstore.data.models.Book

/**
 * Created by Abdul Rehman on 16-05-2020.
 * Contact email - abdulrehman0796@gmail.com
 */

@Dao
interface BookDoa {

    @Query("SELECT * FROM books")
    suspend fun getAllBooks(): List<Book>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg book: Book)

    @Query("DELETE FROM books")
    suspend fun deleteAll()
}
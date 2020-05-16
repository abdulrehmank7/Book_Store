package com.arkapp.bookstore.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Abdul Rehman on 16-05-2020.
 * Contact email - abdulrehman0796@gmail.com
 */
@Entity(tableName = "books")
data class Book(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "author")
    val author: String?,
    @ColumnInfo(name = "summary")
    val summary: String?,
    @ColumnInfo(name = "bookImgRes")
    val bookImgRes: Int?,
    @ColumnInfo(name = "isMostSearch")
    val isMostSearch: Boolean?,
    @ColumnInfo(name = "isBestSeller")
    val isBestSeller: Boolean?,
    @ColumnInfo(name = "isNewArrival")
    val isNewArrival: Boolean?
)
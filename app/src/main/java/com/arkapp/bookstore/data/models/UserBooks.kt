package com.arkapp.bookstore.data.models


/**
 * Created by Abdul Rehman on 16-05-2020.
 * Contact email - abdulrehman0796@gmail.com
 */
data class UserBooks(
    val uid: String,
    var favorites: ArrayList<Book>,
    var borrowedBook: ArrayList<BorrowedBook>
)
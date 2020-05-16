package com.arkapp.bookstore.data.models

import java.util.*


/**
 * Created by Abdul Rehman on 16-05-2020.
 * Contact email - abdulrehman0796@gmail.com
 */

data class BorrowedBook(
    val returnDate: Date,
    val book: Book
)
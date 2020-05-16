package com.arkapp.bookstore.data.models

data class Book(
    var title: String = "",
    var author: String = "",
    var bookImgRes: Int = 0,
    var isFavourite: Boolean = false,
    var isBorrowed: Boolean = false,
    var isMostSearch: Boolean = false,
    var isBestSeller: Boolean = false,
    var isNewArrival: Boolean = false
)
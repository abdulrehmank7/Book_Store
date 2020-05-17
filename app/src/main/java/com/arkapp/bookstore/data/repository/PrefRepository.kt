package com.arkapp.bookstore.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.arkapp.bookstore.data.authentication.getCurrentUser
import com.arkapp.bookstore.data.models.Book
import com.arkapp.bookstore.data.models.BorrowedBook
import com.arkapp.bookstore.data.models.UserBooks
import com.arkapp.bookstore.data.preferences.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*
import kotlin.collections.ArrayList


class PrefRepository(val context: Context) {

    private val pref: SharedPreferences = context.getSharedPreferences(
        PREFERENCE_NAME,
        Context.MODE_PRIVATE
    )
    private val editor = pref.edit()
    private val gson = Gson()

    private fun String.put(long: Long) {
        editor.putLong(this, long)
        editor.commit()
    }

    private fun String.put(int: Int) {
        editor.putInt(this, int)
        editor.commit()
    }

    private fun String.put(string: String) {
        editor.putString(this, string)
        editor.commit()
    }

    private fun String.put(boolean: Boolean) {
        editor.putBoolean(this, boolean)
        editor.commit()
    }


    private fun String.getLong(): Long {
        return pref.getLong(this, 0)
    }

    private fun String.getInt(): Int {
        return pref.getInt(this, 0)
    }

    private fun String.getString(): String {
        return pref.getString(this, "")!!
    }

    private fun String.getBoolean(): Boolean {
        return pref.getBoolean(this, false)
    }

    /*********************************************/

    fun clearData() {
        editor.clear()
        editor.commit()
    }

    fun setLoggedIn(isLoggedIn: Boolean) {
        PREF_LOGGED_IN.put(isLoggedIn)
    }

    fun setLoggedIn() = PREF_LOGGED_IN.getBoolean()

    fun openedBook(book: Book) {
        PREF_OPENED_BOOK.put(gson.toJson(book))
    }

    fun openedBook(): Book = gson.fromJson(PREF_OPENED_BOOK.getString(), Book::class.java)

    fun addToFavourite(book: Book) {

        val allUserBook = getAllUserBooks()
        val userFavBooks = getFavouriteBooks()

        userFavBooks.add(book)

        var userIndex = -1

        allUserBook.forEachIndexed { index, userBooks ->
            if (userBooks.uid == getCurrentUser()?.uid) {
                userIndex = index
                return@forEachIndexed
            }
        }

        if (userIndex != -1) {
            val newUserData = allUserBook[userIndex]
            newUserData.favorites = userFavBooks

            allUserBook.removeAt(userIndex)
            allUserBook.add(newUserData)
        } else {
            allUserBook.add(UserBooks(getCurrentUser()?.uid!!, userFavBooks, ArrayList()))
        }

        PREF_USER_BOOKS.put(gson.toJson(allUserBook))
    }

    fun removeFavourite(book: Book) {

        val allUserBook = getAllUserBooks()
        val userFavBooks = getFavouriteBooks()

        userFavBooks.remove(book)

        var userIndex = -1

        allUserBook.forEachIndexed { index, userBooks ->
            if (userBooks.uid == getCurrentUser()?.uid) {
                userIndex = index
                return@forEachIndexed
            }
        }

        if (userIndex != -1) {
            val newUserData = allUserBook[userIndex]
            newUserData.favorites = userFavBooks

            allUserBook.removeAt(userIndex)
            allUserBook.add(newUserData)
        } else {
            allUserBook.add(UserBooks(getCurrentUser()?.uid!!, userFavBooks, ArrayList()))
        }

        PREF_USER_BOOKS.put(gson.toJson(allUserBook))
    }

    fun isFavouriteExist(book: Book): Boolean {
        val allFavBooks = getFavouriteBooks()
        allFavBooks.find { it == book }.also {
            return it != null
        }
    }

    fun getAllUserBooks(): ArrayList<UserBooks> {
        val type = object : TypeToken<ArrayList<UserBooks>>() {}.type

        PREF_USER_BOOKS.getString().also { allUserBooks ->
            return if (allUserBooks.isNotEmpty()) {
                gson.fromJson(allUserBooks, type)
            } else
                ArrayList()
        }
    }

    fun getFavouriteBooks(): ArrayList<Book> {

        val type = object : TypeToken<ArrayList<UserBooks>>() {}.type

        PREF_USER_BOOKS.getString().also { allUserBooks ->
            if (allUserBooks.isNotEmpty()) {
                val userBooks: ArrayList<UserBooks> = gson.fromJson(allUserBooks, type)

                userBooks.find { it.uid == getCurrentUser()?.uid }.also {
                    return it?.favorites ?: ArrayList()
                }
            } else
                return ArrayList()
        }
    }

    fun getBorrowedBooks(): ArrayList<BorrowedBook> {

        val type = object : TypeToken<ArrayList<UserBooks>>() {}.type

        PREF_USER_BOOKS.getString().also { allUserBooks ->
            if (allUserBooks.isNotEmpty()) {
                val userBooks: ArrayList<UserBooks> = gson.fromJson(allUserBooks, type)

                userBooks.find { it.uid == getCurrentUser()?.uid }.also {
                    return it?.borrowedBook ?: ArrayList()
                }
            } else
                return ArrayList()
        }
    }

    fun addToBorrowed(book: Book) {

        val allUserBook = getAllUserBooks()
        val userBorrowedBooks = getBorrowedBooks()

        val cal = Calendar.getInstance()
        cal.add(Calendar.DAY_OF_YEAR, RETURN_BOOK_DAYS)

        userBorrowedBooks.add(BorrowedBook(cal.time, book))

        var userIndex = -1

        allUserBook.forEachIndexed { index, userBooks ->
            if (userBooks.uid == getCurrentUser()?.uid) {
                userIndex = index
                return@forEachIndexed
            }
        }

        if (userIndex != -1) {
            val newUserData = allUserBook[userIndex]
            newUserData.borrowedBook = userBorrowedBooks

            allUserBook.removeAt(userIndex)
            allUserBook.add(newUserData)
        } else {
            allUserBook.add(UserBooks(getCurrentUser()?.uid!!, ArrayList(), userBorrowedBooks))
        }

        PREF_USER_BOOKS.put(gson.toJson(allUserBook))
    }

    fun removedBorrowed(book: Book) {

        val allUserBook = getAllUserBooks()
        val userBorrowedBooks = getBorrowedBooks()

        val borrowedBook: BorrowedBook

        userBorrowedBooks.find { it.book == book }.also {
            borrowedBook = it!!
        }

        userBorrowedBooks.remove(borrowedBook)

        var userIndex = -1

        allUserBook.forEachIndexed { index, userBooks ->
            if (userBooks.uid == getCurrentUser()?.uid) {
                userIndex = index
                return@forEachIndexed
            }
        }

        if (userIndex != -1) {
            val newUserData = allUserBook[userIndex]
            newUserData.borrowedBook = userBorrowedBooks

            allUserBook.removeAt(userIndex)
            allUserBook.add(newUserData)
        } else {
            allUserBook.add(UserBooks(getCurrentUser()?.uid!!, ArrayList(), userBorrowedBooks))
        }

        PREF_USER_BOOKS.put(gson.toJson(allUserBook))
    }

    fun isBorrowedExist(book: Book): Boolean {
        val allFavBooks = getBorrowedBooks()
        allFavBooks.find { it.book == book }.also {
            return it != null
        }
    }

    fun setBookSearchType(searchType: String) {
        PREF_BOOK_SEARCH_TYPE.put(searchType)
    }

    fun getBookSearchType() = PREF_BOOK_SEARCH_TYPE.getString()
}
package com.arkapp.bookstore.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.arkapp.bookstore.data.models.Book
import com.arkapp.bookstore.data.preferences.PREFERENCE_NAME
import com.arkapp.bookstore.data.preferences.PREF_LOGGED_IN
import com.arkapp.bookstore.data.preferences.PREF_OPENED_BOOK
import com.google.gson.Gson


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

    fun openedBook() = gson.fromJson(PREF_OPENED_BOOK.getString(), Book::class.java)


}
package com.arkapp.bookstore.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arkapp.bookstore.data.models.UserLogin

/**
 * Created by Abdul Rehman on 17-05-2020.
 * Contact email - abdulrehman0796@gmail.com
 */

@Dao
interface UserLoginDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg user: UserLogin)

    @Query("SELECT * FROM USER_LOGIN WHERE userName = :userName AND password =:password")
    suspend fun getLoggedInUser(userName: String, password: String): List<UserLogin>

    @Query("SELECT * FROM USER_LOGIN WHERE email = :email AND password =:password")
    suspend fun getLoggedInUserEmail(email: String, password: String): List<UserLogin>

    @Query("SELECT * FROM USER_LOGIN WHERE userName = :userName")
    suspend fun checkLoggedInUser(userName: String): List<UserLogin>

    @Query("SELECT * FROM USER_LOGIN WHERE email = :email")
    suspend fun checkLoggedInUserEmail(email: String): List<UserLogin>

}
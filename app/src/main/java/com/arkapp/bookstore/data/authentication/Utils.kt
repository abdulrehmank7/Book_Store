package com.arkapp.bookstore.data.authentication

import android.app.Activity
import com.arkapp.bookstore.R
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.AuthUI.IdpConfig
import com.firebase.ui.auth.AuthUI.IdpConfig.EmailBuilder
import com.firebase.ui.auth.AuthUI.IdpConfig.GoogleBuilder
import com.google.firebase.auth.FirebaseAuth


const val RC_SIGN_IN = 786

/**
 * Created by Abdul Rehman on 11-03-2020.
 * Contact email - abdulrehman0796@gmail.com
 */

fun Activity.openLoginScreen() {
    val providers: List<IdpConfig> = listOf(
        EmailBuilder().build(),
        GoogleBuilder().build()
    )

    startActivityForResult(
        AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setTheme(R.style.AppTheme_LoginTheme)
            .setAvailableProviders(providers)
            .setLogo(R.drawable.ic_launcher_big)
            .setIsSmartLockEnabled(false)
            .build(),
        RC_SIGN_IN
    )
}

fun getCurrentUser() = FirebaseAuth.getInstance().currentUser

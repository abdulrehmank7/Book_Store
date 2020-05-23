package com.arkapp.bookstore.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.arkapp.bookstore.R
import com.arkapp.bookstore.data.repository.PrefRepository
import com.arkapp.bookstore.utils.hide
import com.arkapp.bookstore.utils.show
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val prefRepository by lazy { PrefRepository(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.fragment)

        val appBarConfiguration = AppBarConfiguration
            .Builder(
                R.id.homeFragment,
                R.id.favouritesFragment,
                R.id.borrowedFragment,
                R.id.settingFragment
            )
            .build()

        setupWithNavController(bottomNavigation, navController)
        setupActionBarWithNavController(this, navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.splashFragment || destination.id == R.id.signUpFragment) {
                supportActionBar?.hide()
                bottomNavigation.hide()
            } else {
                supportActionBar?.show()
                bottomNavigation.show()
            }

            if (destination.id == R.id.bookDetailsFragment) {
                bottomNavigation.hide()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return true
    }

}

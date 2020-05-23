package com.arkapp.bookstore.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arkapp.bookstore.R
import com.arkapp.bookstore.data.database.AppDatabase
import com.arkapp.bookstore.data.preferences.ENTERED_USER_EMAIL
import com.arkapp.bookstore.data.preferences.ENTERED_USER_NAME
import com.arkapp.bookstore.data.repository.PrefRepository
import com.arkapp.bookstore.utils.hide
import com.arkapp.bookstore.utils.initVerticalAdapter
import com.arkapp.bookstore.utils.show
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val preRepository by lazy { PrefRepository(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progress.show()
        addUserName()
        initBookData()
    }

    private fun initBookData() {
        lifecycleScope.launch(Dispatchers.Main) {
            val bookDao =
                AppDatabase.getDatabase(requireActivity().application).booksDao()

            val books = bookDao.getAllBooks()

            if (books.size >= 16) {
                val adapter = BookListAdapter(
                    books,
                    preRepository,
                    findNavController()
                )
                bookRv.initVerticalAdapter(adapter, true)
                progress.hide()
            } else
                initBookData()
        }
    }

    private fun addUserName() {
        if (ENTERED_USER_NAME.isNotEmpty() || ENTERED_USER_EMAIL.isNotEmpty()) {
            lifecycleScope.launch(Dispatchers.Main) {
                val userLoginDao = AppDatabase.getDatabase(requireContext()).userLoginDao()

                if (ENTERED_USER_NAME.isNotEmpty()) {
                    val userData = userLoginDao.checkLoggedInUser(ENTERED_USER_NAME)
                    preRepository.setCurrentLoginUser(userData[0])
                } else {
                    val userData = userLoginDao.checkLoggedInUserEmail(ENTERED_USER_EMAIL)
                    preRepository.setCurrentLoginUser(userData[0])
                }
            }
        }
    }

}

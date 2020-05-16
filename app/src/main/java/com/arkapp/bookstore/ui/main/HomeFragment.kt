package com.arkapp.bookstore.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arkapp.bookstore.R
import com.arkapp.bookstore.data.repository.PrefRepository
import com.arkapp.bookstore.data.room.AppDatabase
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
        initBookData()
    }

    private fun initBookData() {
        lifecycleScope.launch(Dispatchers.Main) {
            val bookDao =
                AppDatabase.getDatabase(requireActivity().application, lifecycleScope).booksDao()

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

}

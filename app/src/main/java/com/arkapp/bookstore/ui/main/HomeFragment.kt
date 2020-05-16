package com.arkapp.bookstore.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arkapp.bookstore.R
import com.arkapp.bookstore.data.repository.BookRepository
import com.arkapp.bookstore.data.repository.PrefRepository
import com.arkapp.bookstore.utils.initVerticalAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val bookRepository by lazy { BookRepository() }

    private val preRepository by lazy { PrefRepository(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BookListAdapter(
            bookRepository.getAllBooks(),
            preRepository,
            findNavController()
        )
        bookRv.initVerticalAdapter(adapter, true)
    }

}

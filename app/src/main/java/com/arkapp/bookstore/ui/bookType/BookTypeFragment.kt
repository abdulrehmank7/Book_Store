package com.arkapp.bookstore.ui.bookType

import androidx.fragment.app.Fragment
import com.arkapp.bookstore.R
import com.arkapp.bookstore.data.repository.PrefRepository

/**
 * A simple [Fragment] subclass.
 */
class BookTypeFragment : Fragment(R.layout.fragment_favourites) {

    private val preRepository by lazy { PrefRepository(requireContext()) }

}

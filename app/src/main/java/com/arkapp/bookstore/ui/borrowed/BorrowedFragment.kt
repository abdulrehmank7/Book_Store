package com.arkapp.bookstore.ui.borrowed

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arkapp.bookstore.R
import com.arkapp.bookstore.data.repository.PrefRepository
import com.arkapp.bookstore.utils.hide
import com.arkapp.bookstore.utils.initVerticalAdapter
import com.arkapp.bookstore.utils.show
import kotlinx.android.synthetic.main.fragment_borrowed.*

/**
 * A simple [Fragment] subclass.
 */
class BorrowedFragment : Fragment(R.layout.fragment_borrowed) {

    private val preRepository by lazy { PrefRepository(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val borrow = preRepository.getBorrowBooks()
        if (borrow.size > 0) {
            noBorrowTv.hide()

            val adapter = BorrowListAdapter(
                borrow,
                preRepository,
                findNavController()
            )
            borrowRv.initVerticalAdapter(adapter, true)
        } else
            noBorrowTv.show()
    }

}

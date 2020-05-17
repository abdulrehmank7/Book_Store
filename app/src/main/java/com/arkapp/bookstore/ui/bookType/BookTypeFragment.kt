package com.arkapp.bookstore.ui.bookType

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.arkapp.bookstore.R
import com.arkapp.bookstore.data.models.Book
import com.arkapp.bookstore.data.preferences.BOOK_TYPE_BEST_SELLER
import com.arkapp.bookstore.data.preferences.BOOK_TYPE_MOST_SEARCHED
import com.arkapp.bookstore.data.preferences.BOOK_TYPE_NEW_ARRIVAL
import com.arkapp.bookstore.data.repository.PrefRepository
import com.arkapp.bookstore.data.room.AppDatabase
import com.arkapp.bookstore.ui.main.MainActivity
import com.arkapp.bookstore.utils.initVerticalAdapter
import kotlinx.android.synthetic.main.fragment_favourites.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class BookTypeFragment : Fragment(R.layout.fragment_favourites) {

    private val preRepository by lazy { PrefRepository(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as MainActivity).supportActionBar?.title =
            preRepository.getBookSearchType()

        initBookList()
    }

    private fun initBookList() {

        lifecycleScope.launch(Dispatchers.Main) {
            val bookDao =
                AppDatabase.getDatabase(requireActivity().application, lifecycleScope).booksDao()

            val books =
                when (preRepository.getBookSearchType()) {
                    BOOK_TYPE_BEST_SELLER -> {
                        bookDao.getBestSeller()
                    }
                    BOOK_TYPE_NEW_ARRIVAL -> bookDao.getNewArrival()
                    BOOK_TYPE_MOST_SEARCHED -> bookDao.getMostSearched()
                    else -> bookDao.getMostSearched()
                }

            val adapter = BookTypeListAdapter(
                books as ArrayList<Book>,
                preRepository,
                findNavController()
            )
            favouriteRv.initVerticalAdapter(adapter, true)
        }
    }
}

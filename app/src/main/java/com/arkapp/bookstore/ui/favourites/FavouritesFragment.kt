package com.arkapp.bookstore.ui.favourites

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.arkapp.bookstore.R
import com.arkapp.bookstore.data.repository.PrefRepository
import com.arkapp.bookstore.utils.hide
import com.arkapp.bookstore.utils.initVerticalAdapter
import com.arkapp.bookstore.utils.show
import kotlinx.android.synthetic.main.fragment_favourites.*

/**
 * A simple [Fragment] subclass.
 */
class FavouritesFragment : Fragment(R.layout.fragment_favourites) {

    private val preRepository by lazy { PrefRepository(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val favourites = preRepository.getFavouriteBooks()
        if (favourites.size > 0) {
            noFavouritesTv.hide()

            val adapter = FavouriteListAdapter(
                favourites,
                preRepository,
                findNavController()
            )
            favouriteRv.initVerticalAdapter(adapter, true)
        } else
            noFavouritesTv.show()
    }

}

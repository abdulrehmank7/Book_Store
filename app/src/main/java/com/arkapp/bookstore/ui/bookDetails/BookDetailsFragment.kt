package com.arkapp.bookstore.ui.bookDetails

import android.content.DialogInterface
import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arkapp.bookstore.R
import com.arkapp.bookstore.data.models.Book
import com.arkapp.bookstore.data.repository.PrefRepository
import com.arkapp.bookstore.databinding.FragmentBookDetailsBinding
import com.arkapp.bookstore.utils.*


/**
 * A simple [Fragment] subclass.
 */
class BookDetailsFragment : Fragment() {

    private lateinit var binding: FragmentBookDetailsBinding

    private val prefRepository by lazy { PrefRepository(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.explode)

        binding = FragmentBookDetailsBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bookData = prefRepository.openedBook()

        initBookData(bookData)
        initDescription(bookData)
        initFavouriteBtn(bookData)

    }

    private fun initBookData(bookData: Book) {
        binding.title.text = bookData.title
        binding.author.text = bookData.author
        binding.bookCover.loadImage(bookData.bookImgRes)
    }

    private fun initDescription(bookData: Book) {
        when {
            bookData.isMostSearch -> {
                binding.descCard.show()
                binding.desc.text = getString(R.string.most_searched)
            }
            bookData.isBestSeller -> {
                binding.descCard.show()
                binding.desc.text = getString(R.string.best_seller)
            }
            bookData.isNewArrival -> {
                binding.descCard.show()
                binding.desc.text = getString(R.string.new_arrival)
            }
            else -> binding.descCard.hide()
        }
    }

    private fun initFavouriteBtn(bookData: Book) {
        if (prefRepository.isFavouriteExist(bookData)) {
            binding.favourtieBtn.text = getString(R.string.remove_from_fav)

            binding.favourtieBtn.setOnClickListener {
                requireContext().showAlertDialog(
                    "Delete Favourite",
                    "Do you want to remove this book to favourites?",
                    "Remove",
                    "Cancel",
                    DialogInterface.OnClickListener { dialog, _ ->
                        prefRepository.removeFavourite(bookData)
                        requireContext().toast("Removed successfully!")
                        binding.favourtieBtn.text = getString(R.string.add_to_favourites)
                        dialog.dismiss()
                    }
                )
            }
        } else {
            binding.favourtieBtn.text = getString(R.string.add_to_favourites)

            binding.favourtieBtn.setOnClickListener {
                requireContext().showAlertDialog(
                    "Add Favourite",
                    "Do you want to add this book to favourites?",
                    "ADD",
                    "Cancel",
                    DialogInterface.OnClickListener { dialog, _ ->
                        prefRepository.addToFavourite(bookData)
                        requireContext().toast("Added successfully!")
                        binding.favourtieBtn.text = getString(R.string.remove_from_fav)
                        dialog.dismiss()
                    }
                )
            }
        }
    }

}

package com.arkapp.bookstore.ui.bookDetails

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.arkapp.bookstore.data.repository.PrefRepository
import com.arkapp.bookstore.databinding.FragmentBookDetailsBinding
import com.arkapp.bookstore.ui.main.MainActivity
import com.arkapp.bookstore.utils.loadImage


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
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)

        binding = FragmentBookDetailsBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bookData = prefRepository.openedBook()
        binding.title.text = bookData.title
        binding.author.text = bookData.author
        binding.bookCover.loadImage(bookData.bookImgRes)
    }

}

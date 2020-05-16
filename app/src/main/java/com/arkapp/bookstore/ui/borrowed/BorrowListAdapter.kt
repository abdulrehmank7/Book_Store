package com.arkapp.bookstore.ui.borrowed

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.arkapp.bookstore.R
import com.arkapp.bookstore.data.models.BorrowedBook
import com.arkapp.bookstore.data.repository.PrefRepository
import com.arkapp.bookstore.utils.getDaysLeft
import com.arkapp.bookstore.utils.getFormattedDate
import com.arkapp.bookstore.utils.loadImage

/**
 * Created by Abdul Rehman on 28-02-2020.
 * Contact email - abdulrehman0796@gmail.com
 */

class BorrowListAdapter(
    private val books: ArrayList<BorrowedBook>,
    private val prefRepository: PrefRepository,
    private val navController: NavController
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BorrowedViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.rv_borrowed_book_list,
                parent,
                false
            )
        )
    }

    @SuppressLint("ClickableViewAccessibility", "SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as BorrowedViewHolder).viewBinding

        val bookData = books[position].book
        binding.bookTitle.text = bookData.title
        binding.bookAuthor.text = bookData.author
        binding.bookImg.loadImage(bookData.bookImgRes!!)

        val dayLeft = books[position].returnDate.getDaysLeft()

        if (dayLeft > 0)
            binding.dayLeft.text = "$dayLeft Days left!"
        else
            binding.dayLeft.text = "Expired!"

        binding.returnDate.text = books[position].returnDate.getFormattedDate()

        binding.parent.setOnClickListener {
            prefRepository.openedBook(bookData)
            navController.navigate(R.id.action_borrowedFragment_to_bookDetailsFragment)
        }
    }


    override fun getItemCount() = books.size

    override fun getItemId(position: Int): Long {
        return books[position].hashCode().toLong()
    }

}
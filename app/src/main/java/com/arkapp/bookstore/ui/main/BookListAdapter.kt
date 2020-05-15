package com.arkapp.bookstore.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.arkapp.bookstore.R
import com.arkapp.bookstore.data.models.Book
import com.arkapp.bookstore.utils.loadImage

/**
 * Created by Abdul Rehman on 28-02-2020.
 * Contact email - abdulrehman0796@gmail.com
 */

class BookListAdapter(private val books: ArrayList<Book>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BookListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.rv_book_list_main,
                parent,
                false
            )
        )
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as BookListViewHolder).viewBinding

        val bookData = books[position]
        binding.bookTitle.text = bookData.title
        binding.bookAuthor.text = bookData.author
        binding.bookImg.loadImage(bookData.bookImgRes)
    }


    override fun getItemCount() = books.size

    override fun getItemId(position: Int): Long {
        return books[position].hashCode().toLong()
    }

}
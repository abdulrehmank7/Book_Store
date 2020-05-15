package com.arkapp.bookstore.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.arkapp.bookstore.R
import com.arkapp.bookstore.utils.initVerticalAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BookListAdapter(ArrayList())
        bookRv.initVerticalAdapter(adapter, true)
    }

}

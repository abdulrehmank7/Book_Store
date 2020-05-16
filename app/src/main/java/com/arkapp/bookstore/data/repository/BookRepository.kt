package com.arkapp.bookstore.data.repository

import com.arkapp.bookstore.R
import com.arkapp.bookstore.data.models.Book

/**
 * Created by Abdul Rehman on 16-05-2020.
 * Contact email - abdulrehman0796@gmail.com
 */
class BookRepository {

    fun getAllBooks(): ArrayList<Book> {
        val books = ArrayList<Book>()
        books.add(
            Book(
                "From Third World to First Hardcover – 2 October 2000",
                "Lee Kuan Yew",
                R.drawable.book1
            )
        )

        books.add(
            Book(
                "This Is What Inequality Looks Like",
                "Teo You Yenn",
                R.drawable.book2
            )
        )

        books.add(
            Book(
                "How We Disappeared",
                "Jing-Jing Lee",
                R.drawable.book3
            )
        )

        books.add(
            Book(
                "Singapore: A Biography",
                "Mark Ravinder Frost",
                R.drawable.book4
            )
        )

        books.add(
            Book(
                "Secrets of Singapore: Botanic Gardens",
                "Monica Lim and Lesley-Anne Tan",
                R.drawable.book5
            )
        )

        books.add(
            Book(
                "Fistful of Colours",
                "Suchen Christine Lim",
                R.drawable.book6
            )
        )

        books.add(
            Book(
                "Aunty Lee's Delights",
                "Ovidia Yu",
                R.drawable.book7
            )
        )

        books.add(
            Book(
                "Ponti",
                "Sharlene Teo",
                R.drawable.book8
            )
        )

        books.add(
            Book(
                "The Little Singapore Book",
                "Joyceline See Tully and Sim Ee Waun",
                R.drawable.book9
            )
        )

        books.add(
            Book(
                "Notes from an Even Smaller Island",
                "Neil Humphreys",
                R.drawable.book10
            )
        )

        books.add(
            Book(
                "Now That It's Over",
                "O Thiam Chin",
                R.drawable.book11
            )
        )

        books.add(
            Book(
                "State of Emergency",
                "Jeremy Tiang",
                R.drawable.book12
            )
        )

        books.add(
            Book(
                "Hard at Work: Life in Singapore",
                "Gerard Sasges and Ng Shi Wen",
                R.drawable.book13
            )
        )

        books.add(
            Book(
                "Singapore Noir",
                "Cheryl Lu-Lien Tan",
                R.drawable.book14
            )
        )

        books.add(
            Book(
                "Tall Order: The Goh Chok Tong Story (Volume 1)",
                "Shing Huei Peh",
                R.drawable.book15
            )
        )

        books.add(
            Book(
                "Singapore: A Pictorial History, 1819-2000",
                "Gretchen Liu",
                R.drawable.book16
            )
        )

        books.add(
            Book(
                "One Man's View of the World Hardcover – 1",
                "LEE KUAN YEW",
                R.drawable.book17
            )
        )

        return books
    }
}
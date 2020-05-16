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
                1,
                "From Third World to First Hardcover – 2 October 2000",
                "Lee Kuan Yew",
                "The story of Singapore’s amazing transformation told by it’s charismatic and controversial founding father, Lee Kuan Yew.\n" +
                        "Lee Kuan Yew is one of the most influential leaders in Asia. In this illuminating account, Lee writes frankly about his disapproving approach to political opponents and his often unorthodox views on human rights, democracy, and inherited intelligence, aiming always “to be correct, not politically correct.”\n" +
                        "Since it’s independence in 1965, tiny Singapore – once a poor and decrepit colony – has risen to become a rich and thriving Asian metropolis.",
                R.drawable.book1,
                isMostSearch = true,
                isBestSeller = false,
                isNewArrival = false
            )
        )

        books.add(
            Book(
                2,
                "This Is What Inequality Looks Like",
                "Teo You Yenn",
                "What is poverty? What is inequality? How are they connected? How are they reproduced? How might they be overcome? Why should we try?\n" +
                        "The way we frame our questions shapes the way we see solutions. This book does what appears to be a no-brainer task, but one that is missing and important: it asks readers to pose questions in different ways, to shift the vantage point from which they view ‘common sense,’ and in so doing, to see themselves as part of problems and potential solutions. This is a book about how seeing poverty entails confronting inequality. It is about how acknowledging poverty and inequality leads to uncomfortable revelations about our society and ourselves. And it is about how once we see, we cannot, must not, unsee.",
                R.drawable.book2,
                isMostSearch = false,
                isBestSeller = true,
                isNewArrival = false
            )
        )

        books.add(
            Book(
                3,
                "How We Disappeared",
                "Jing-Jing Lee",
                "A novel set in Singapore about a woman who survived the Japanese occupation and a man who thought he had lost everything.\n" +
                        "\n" +
                        "Singapore, 1942. As Japanese troops sweep down Malaysia and into Singapore, a village is ransacked, leaving only two survivors and one tiny child.",
                R.drawable.book3,
                isMostSearch = false,
                isBestSeller = false,
                isNewArrival = true
            )
        )

        books.add(
            Book(
                4,
                "Singapore: A Biography",
                "Mark Ravinder Frost",
                "Brimming with verve and dramatic incident, Singapore: A Biography offers fresh insights into the life story of this island city-state through the personal experiences of the workers, adventurers, rulers and revolutionaries who have shaped its history over the last seven centuries. The authors, drawing on research undertaken in collaboration with the National Museum of Singapore, have woven together ancient chronicles, eyewitness accounts, oral histories and even modern radio and television broadcasts to create a vivid and compelling narrative that brings the past back to life. Grounded in scholarship yet fired by the imagination, this book reveals the Singapore story to have been as rich, diverse and multilayered as the city-state is prosperous, ordered and successful today.",
                R.drawable.book4,
                isMostSearch = false,
                isBestSeller = true,
                isNewArrival = false
            )
        )

        books.add(
            Book(
                5,
                "Secrets of Singapore: Botanic Gardens",
                "Monica Lim and Lesley-Anne Tan",
                "In Secrets of Singapore: Botanic Gardens, Danger Dan and Gadget Girl go out on a limb to uproot the Singapore Botanic Gardens’ deepest, darkest secrets.\n" +
                        "Within the lush grounds, the superhero duo find a tree so famous that its portrait can be found in any Singaporean’s wallet, as well as an orchid older and taller than any human alive. Flying back 140 years into the past, they also discover that the Botanic Gardens used to be home to a mixed bag of critters, including a tapir who dreamed of being a rock. Not a rock star. Just a rock. #achievablegoals\n" +
                        "There’s more! Danger Dan and Gadget Girl realise that the botanical world is more twisted than they think. As it turns out, strawberries are only pretending to be berries, tomatoes can’t decide whether they are fruits or vegetables, and sunflowers are really evil at heart.",
                R.drawable.book5,
                isMostSearch = true,
                isBestSeller = false,
                isNewArrival = false
            )
        )

        books.add(
            Book(
                6,
                "Fistful of Colours",
                "Suchen Christine Lim",
                "Fistful of Colours is a elegant, multi-layered reflection on Singapore as experienced through one day in the life of Ong Suwen, a young teacher in search of her identity as a woman and an artist. Peering into the rich history of her stepfather's family, Suwen uncovers and reveals the hopes and struggles of Singapore's first generation of immigrants and residents - from Chinese collies, Indian doctors and Malay waiters, each is given a unique and vibrant voice. Woven into this narrative are stories of Suwen's fellow artists that touch upon themes of art, identity and the pursuit of personal and artistic freedom.",
                R.drawable.book6,
                isMostSearch = false,
                isBestSeller = false,
                isNewArrival = true
            )
        )

        books.add(
            Book(
                7,
                "Aunty Lee's Delights",
                "Ovidia Yu",
                "This delectable and witty mystery introduces Rosie \"Aunty\" Lee, feisty widow, amateur sleuth and proprietor of Singapore's best-loved home cooking restaurant\n" +
                        "\n" +
                        "After losing her husband, Rosie Lee could easily have become one of Singapore's \"tai tai,\" an idle rich lady devoted to mah-jongg and luxury shopping. Instead she threw herself into building a culinary empire from her restaurant, Aunty Lee's Delights, where spicy Singaporean home cooking is graciously served to locals and tourists alike. But when a body is found in one of Singapore's beautiful tourist havens, and when one of her wealthy guests fails to show at a dinner party, Aunty Lee knows that the two are likely connected.",
                R.drawable.book7,
                isMostSearch = false,
                isBestSeller = false,
                isNewArrival = true
            )
        )

        books.add(
            Book(
                8,
                "Ponti",
                "Sharlene Teo",
                "2003, Singapore. Friendless and fatherless, sixteen-year-old Szu lives in the shadow of her mother Amisa, once a beautiful actress and now a hack medium performing séances with her sister in a rusty house. When Szu meets the privileged, acid-tongued Circe, an unlikely encounter develops into an intense friendship and offers Szu a means of escape from her mother's alarming solitariness.\n" +
                        "\n" +
                        "Seventeen years later, Circe is struggling through a divorce in fraught and ever-changing Singapore when a project comes up at work: a remake of the cult seventies horror film series 'Ponti', the very project that defined Amisa's short-lived film career. Suddenly Circe is knocked off balance: by memories of the two women she once knew, by guilt, and by a past that threatens her conscience.",
                R.drawable.book8,
                isMostSearch = true,
                isBestSeller = false,
                isNewArrival = false
            )
        )

        books.add(
            Book(
                9,
                "The Little Singapore BookData",
                "Joyceline See Tully and Sim Ee Waun",
                "The Little Singapore Book is the story of Singapore, written for children between 5 and 10 years old. \n" +
                        "It will introduce young readers to our history and culture through simple storytelling language, vivid illustrations packed with detail and a fresh perspective. It promises to be an enjoyable read interwoven with plenty of discovery.\n" +
                        "The book has five chapters and starts with a simplified history of Singapore from the 14th century through nation building and to the present day, then on to a whirlwind tour of the historical districts of Singapore.",
                R.drawable.book9,
                isMostSearch = false,
                isBestSeller = true,
                isNewArrival = false
            )
        )

        books.add(
            Book(
                10,
                "Notes from an Even Smaller Island",
                "Neil Humphreys",
                "Knowing nothing of Singapore, young Englishman Neil Humphreys arrives in the land of air-conned shopping centres and Lee Kuan Yew.\n" +
                        "From the aunties in the hawker centres to expats dressed as bananas, from Singlish to kiasuism, and from Singaporeans at home to Singaporeans abroad, Humphreys explores all aspects of Singaporean life, taking in the sights, dissecting the culture and illuminating each place and person with his perceptive and witty observations.",
                R.drawable.book10,
                isMostSearch = false,
                isBestSeller = false,
                isNewArrival = true
            )
        )

        books.add(
            Book(
                11,
                "Now That It's Over",
                "O Thiam Chin",
                "During the Christmas holidays in 2004, an earthquake in the Indian Ocean triggers a tsunami that devastates fourteen countries. Two couples from Singapore are vacationing in Phuket when the tsunami strikes. Alternating between the aftermath of the catastrophe and past events that led these characters to that fateful moment, Now That It's Over weaves a tapestry of causality and regret, and chronicles the physical and emotional wreckage wrought by natural and manmade disasters.",
                R.drawable.book11,
                isMostSearch = true,
                isBestSeller = false,
                isNewArrival = false
            )
        )

        books.add(
            Book(
                12,
                "State of Emergency",
                "Jeremy Tiang",
                "Siew Li leaves her husband and children in Tiong Bahru to fight for freedom in the jungles of Malaya. Years later, a Malaysian journalist returns to her homeland to uncover the truth of a massacre committed during the Emergency. And in Singapore, Siew Li's niece Stella finds herself accused of being a Marxist conspirator.\n" +
                        "\n" +
                        "Jeremy Tiang's debut novel dives into the tumultuous days of leftist movements and political detentions in Singapore and Malaysia. It follows an extended family from the 1940s to the present day as they navigate the choppy political currents of the region. What happens when the things that divide us also bind us together?",
                R.drawable.book12,
                isMostSearch = false,
                isBestSeller = true,
                isNewArrival = false
            )
        )

        books.add(
            Book(
                13, "Hard at Work: Life in Singapore",
                "Gerard Sasges and Ng Shi Wen",
                "Have you ever wondered what your barista is thinking as she makes your morning coffee? What’s it like to be a successful restaurateur in a ruthlessly competitive market? How did a young Thai woman come to work in a hostess bar? Is an academic ghostwriter undermining or shoring up a world-famous education system? How does a drag performer explain her profession to her conservative parents? And what does an elderly tissue vendor make of the momentous changes she’s seen in Singapore since independence?\n" +
                        "In Hard at Work, sixty people talk about work and life in contemporary Singapore. Their stories shed light not just on Singapore’s present but also its past and its future, and reveal the nation as a place where people from around the world work hard to survive and sometimes thrive in a modern global city. The book offers readers a unique opportunity to look beyond the nation’s iconic skyline and gleaming surfaces to explore the diverse experiences of work and life in Singapore today.",
                R.drawable.book13,
                isMostSearch = false,
                isBestSeller = false,
                isNewArrival = true
            )
        )

        books.add(
            Book(
                14,
                "Singapore Noir",
                "Cheryl Lu-Lien Tan",
                "\"Say Singapore to anyone and you'll likely hear one of a few words: Caning. Fines. Chewing gum.\n" +
                        "\n" +
                        "For much of the West, the narrative of Singapore--a modern Southeast Asian city-state perched on an island on the tip of the Malay Peninsula--has been marked largely by its government's strict laws and unwavering enforcement of them...As much as I understand these outside viewpoints, I have always lamented that the quirky and dark complexities of my native country's culture rarely seem to make it past its borders...\n" +
                        "\n" +
                        "Beneath its sparkling veneer is a country teeming with shadows...And its stories remain. The rich stories that attracted literary lions W. Somerset Maugham and Rudyard Kipling to hold court at the Raffles Hotel (where the Singapore Sling was created) are still sprinkled throughout its neighborhoods. And in the following pages, you'll get the chance to discover some of them...\n" +
                        "\n" +
                        "You'll find stories from some of the best contemporary writers in Singapore--three of them winners of the Singapore Literature Prize, essentially the country's Pulitzer: Simon Tay, writing as Donald Tee Quee Ho, tells the story of a hard-boiled detective who inadvertently wends his way into the underbelly of organized crime, Colin Cheong shows us a surprising side to the country's ubiquitous cheerful 'taxi uncle,' while Suchen Christine Lim spins a wistful tale of a Chinese temple medium whose past resurges to haunt her...",
                R.drawable.book14,
                isMostSearch = false,
                isBestSeller = true,
                isNewArrival = false
            )
        )

        books.add(
            Book(
                15,
                "Tall Order: The Goh Chok Tong Story (Volume 1)",
                "Shing Huei Peh",
                "Goh Chok Tong was an improbable Prime Minister for an unlikely country. He had neither the connections nor the cunning to rise to the top, and was even once famously derided by his mentor Lee Kuan Yew for being \"wooden\" in his communication skills. Except for an imposing height most unusual in this part of the world, he was an ordinary man. He lost his father at a young age, lived in a two-bedroom public flat with his mother and four siblings and needed a government bursary to complete university.\n" +
                        "Yet somehow he succeeded. Tall Order tells the extraordinary story of his life and career over half a century, revealing how Singapore's second Prime Minister rose through a combination of strength, wit and a political nous which many, including himself, did not know he had. In this first of two volumes, Goh navigated years of a challenging apprenticeship to Lee, scoring numerous policy successes but also suffering political blows and humiliation.",
                R.drawable.book15,
                isMostSearch = false,
                isBestSeller = false,
                isNewArrival = true
            )
        )

        books.add(
            Book(
                16,
                "Singapore: A Pictorial History, 1819-2000",
                "Gretchen Liu",
                "With over 1,200 images, Singapore: A Pictorial History 1819-2000 tells the story of Singapore through the eyes of the artists and photographers who witnessed and recorded it. Faded pencil sketches, brilliant watercolours, engravings but mostly photographs - including the first views produced by 19th century professionals, stunning studio portraits and the remarkable experiments of early amateurs. With eloquence, they present the history of a society originally composed mainly of immigrants and of the island they transformed from a fishing village to a global city.\n" +
                        "The quest for the new and the fascinating has unearthed many fresh images reproduced here for the first time alongside classics without which no visual history of Singapore would be complete. What makes them so extraordinary are their unique ties to Singapore, ties to ordinary people and everyday affairs as much as to major events and personalities. From this sumptuous trove, Singapore's history is brought vividly to life.",
                R.drawable.book16,
                isMostSearch = true,
                isBestSeller = false,
                isNewArrival = false
            )
        )

        books.add(
            Book(
                17,
                "One Man's View of the World Hardcover – 1",
                "LEE KUAN YEW",
                "Born in 1923, Singapore’s former Prime Minister Lee Kuan Yew has spent a lifetime being intimately involved in international affairs. He has met every major Chinese leader from Mao Zedong to Xi Jinping and hobnobbed with American presidents from Lyndon Johnson to Barack Obama. In this book, Lee draws on that wealth of experience and depth of insight to offer his views on today’s world and what it might look like in 20 years. This is no dry geopolitical treatise. Nor is it a thematic account of the twists and turns in global affairs. Instead, in this broad-sweep narrative that takes in America, China, Asia and Europe, he parses their society, probes the psyche of the people and draws his conclusions about their chances for survival and just where they might land in the hierarchy of tomorrow’s balance of power.",
                R.drawable.book17,
                isMostSearch = false,
                isBestSeller = false,
                isNewArrival = true
            )
        )

        return books
    }


}
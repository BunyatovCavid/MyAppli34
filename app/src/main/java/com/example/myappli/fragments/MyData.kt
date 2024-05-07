package com.example.myappli.fragments

import com.bumptech.glide.Glide
import com.example.myappli.ItemData

class MyData {

    fun GetDatas(choose : Int) : List<ItemData> {

        var response = listOf<ItemData>()

        var data = arrayListOf(

            ItemData(

                id = 1,

                name = "Orkhan",

                address = "Azerbaijan/Baku/Yasamal",

                imageUrl = "https://icon2.cleanpng.com/20240324/hbz/transparent-world-obesity-day-obesity-fast-food-unhealthy-eati-overweight-man-in-shirt-holds-hamburger-happily65fffc54b98529.63858629.webp",

                isActive = true

            ),

            ItemData(

                id = 2,

                name = "Lisa",

                address = "Poland/Warsaw",

                imageUrl = "https://icon2.cleanpng.com/lnd/20240422/hvr/transparent-little-black-girl-fashion-style-clothing-outfit-image-url-required-for-picture-submission6626f0e8a25679.39246553.webp",

                isActive = true

            ),

            ItemData(

                id = 3,

                name = "Alex",

                address = "England/London",

                imageUrl = "https://icon2.cleanpng.com/20240226/alo/transparent-employee-appreciation-day-hospitality-restaurant-c-smiling-man-in-orange-shirt-and-1710864587950.webp",

                isActive = false

            ),

            ItemData(

                id = 4,

                name = "Ahmad",

                address = "Azerbaijan/Guba",

                imageUrl = "https://icon2.cleanpng.com/20240324/hbz/transparent-world-obesity-day-obesity-fast-food-unhealthy-eati-overweight-man-in-shirt-holds-hamburger-happily65fffc54b98529.63858629.webp",

                isActive = true

            ),

            ItemData(

                id = 5,

                name = "Mariana",

                address = "Ukraine/Kiev",

                imageUrl = "https://icon2.cleanpng.com/lnd/20240422/hvr/transparent-little-black-girl-fashion-style-clothing-outfit-image-url-required-for-picture-submission6626f0e8a25679.39246553.webp",

                isActive = false

            ),

            ItemData(

                id = 6,

                name = "Alex",

                address = "England/London",

                imageUrl = "https://icon2.cleanpng.com/20240226/alo/transparent-employee-appreciation-day-hospitality-restaurant-c-smiling-man-in-orange-shirt-and-1710864587950.webp",

                isActive = true

            ),

            ItemData(

                id = 7,

                name = "Ahmad",

                address = "Azerbaijan/Guba",

                imageUrl = "https://icon2.cleanpng.com/20240324/hbz/transparent-world-obesity-day-obesity-fast-food-unhealthy-eati-overweight-man-in-shirt-holds-hamburger-happily65fffc54b98529.63858629.webp",

                isActive = false

            ),

            ItemData(

                id = 8,

                name = "Susan",

                address = "USA/New York",

                imageUrl = "https://icon2.cleanpng.com/lnd/20240422/hvr/transparent-little-black-girl-fashion-style-clothing-outfit-image-url-required-for-picture-submission6626f0e8a25679.39246553.webp",

                isActive = true

            ),

            ItemData(

                id = 9,

                name = "Mustafa",

                address = "Turkey/Ankara",

                imageUrl = "https://icon2.cleanpng.com/20240226/alo/transparent-employee-appreciation-day-hospitality-restaurant-c-smiling-man-in-orange-shirt-and-1710864587950.webp",

                isActive = false

            )
        )

        when(choose)
        {
            1-> {
                 data.forEach{item->
                     response+=item
                 }
                true
            }

            2-> {
                data.forEach{item->
                    if(item.isActive==true)  response+=item
                }
                true
            }

            3-> {
                data.forEach{item->
                    if(item.isActive==false)  response+=item
                }
                true
            }
        }


        return response
    }


}
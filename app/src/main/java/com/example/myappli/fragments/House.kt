package com.example.myappli.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myappli.Adapters.BrandAdapter
import com.example.myappli.DataClasses.Brand
import com.example.myappli.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [House.newInstance] factory method to
 * create an instance of this fragment.
 */
class House : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        var data1 = listOf<Brand>(
            Brand("https://icon2.cleanpng.com/20240226/alo/transparent-employee-appreciation-day-hospitality-restaurant-c-smiling-man-in-orange-shirt-and-1710864587950.webp"
        )
        )

        for(i in 1..5)
        {
            data1+= Brand("https://icon2.clean'png.com/20240226/alo/transparent-employee-appreciation-day-hospitality-restaurant-c-smiling-man-in-orange-shirt-and-1710864587950.webp")
        }

        val view =inflater.inflate(R.layout.fragment_house, container, false)
        val recycle = view.findViewById<RecyclerView>(R.id.recycle1)
        recycle.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recycle.adapter= BrandAdapter(data1)


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment House.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            House().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
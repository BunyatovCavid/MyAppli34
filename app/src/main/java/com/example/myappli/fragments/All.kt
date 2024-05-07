package com.example.myappli.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.myappli.ItemData
import com.example.myappli.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [All.newInstance] factory method to
 * create an instance of this fragment.
 */
class All : Fragment(), ItemAdapter.OnItemClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
   private  lateinit   var recycle:RecyclerView
   private  lateinit   var data:List<ItemData>
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

        var view = inflater.inflate(R.layout.fragment_all, container, false)
        recycle = view.findViewById<RecyclerView>(R.id.recycle)

        data = MyData().GetDatas(1)
        recycle.layoutManager = LinearLayoutManager(context)
        recycle.adapter= ItemAdapter(data, this)

        recycle.setOnClickListener(){       
        }



        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment All.
         */
        // TODO: Rename and change types and number of parameters



        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            All().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun alertDialog(position: Int) {
        view?.let {
            MaterialAlertDialogBuilder(it.context).setTitle("Alert")
                .setMessage(data[position].name + "selected"
                )
                .setNegativeButton("No"){dialog, which->
                }
                .show()
        }
    }
}
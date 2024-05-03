package com.example.myappli

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {

    //private lateinit var binding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  binding = ActivityMain2Binding.inflate()
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        var list1 = findViewById<ListView>(R.id.products)
        var list2 = findViewById<ListView>(R.id.clients)

        val prods = arrayOf("A","B","C")
        val clients = arrayOf("1","2","3")

        list1.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,prods)

        list1.setOnItemClickListener{adapterView,view, i, l->
                 Toast.makeText(this, "Item Selected" + prods[i], Toast.LENGTH_LONG)
                     .show()
        }

        list2.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,clients)

        list2.setOnItemClickListener{adapterView,view, i, l->
            Toast.makeText(this, "Item Selected" + clients[i], Toast.LENGTH_LONG)
                .show()
        }

         val but = findViewById<Button>(R.id.btn)


        but.setOnClickListener(){
            MaterialAlertDialogBuilder(this).setTitle("Alert")
                .setMessage("You want change list?")
                .setNegativeButton("No"){dialog, which->
                }
                .setPositiveButton("Yes"){dialog,which->
                    if(list1.visibility== View.VISIBLE)
                    {
                        list1.visibility=View.GONE
                        list2.visibility=View.VISIBLE
                    }
                    else
                    {
                        list2.visibility=View.GONE
                        list1.visibility=View.VISIBLE
                    }
                }
                .show()


        }


    }
}




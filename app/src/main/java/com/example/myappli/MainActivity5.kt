package com.example.myappli

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myappli.Adapters.BrandAdapter
import com.example.myappli.Adapters.GoodsAdapter
import com.example.myappli.DataClasses.Brand
import com.example.myappli.DataClasses.Goods
import com.example.myappli.fragments.All
import com.example.myappli.fragments.Dresses
import com.example.myappli.fragments.House
import com.example.myappli.fragments.ItemAdapter
import com.example.myappli.fragments.MyData
import com.example.myappli.fragments.Offline
import com.example.myappli.fragments.Online
import com.example.myappli.fragments.Setting
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.zip.Inflater

class MainActivity5 : AppCompatActivity() {

    private lateinit var navb : BottomNavigationView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)
        var con = findViewById<FrameLayout>(R.id.container15)
        load(House(), Dresses())
        navb=findViewById(R.id.nav) as BottomNavigationView
        navb.setOnItemSelectedListener {
            when(it.itemId)
            {
                R.id.all-> {
                    con.visibility=View.VISIBLE
                    load(House(), Dresses())
                    true
                }
                R.id.Online-> {
                    load(Online())
                    con.visibility = View.GONE
                    true
                }
                R.id.offline-> {
                    load(Offline())
                    con.visibility = View.GONE
                    true
                }
                else->{
                    true}
            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }







    }

    @SuppressLint("SuspiciousIndentation")
    private fun load(fragment : Fragment){
        val  tra = supportFragmentManager.beginTransaction()
        tra.replace(R.id.container16,fragment)
        tra.commit()
    }

    private fun load(fragment : Fragment, fragment2 :Fragment){
        val  tra = supportFragmentManager.beginTransaction()
        tra.replace(R.id.container15,fragment)
        tra.replace(R.id.container16,fragment2)
        tra.commit()
    }
}
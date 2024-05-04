package com.example.myappli

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.example.myappli.fragments.All
import com.example.myappli.fragments.Home
import com.example.myappli.fragments.Offline
import com.example.myappli.fragments.Online
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity4 : AppCompatActivity() {

    private lateinit var navb : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navb=findViewById(R.id.nav) as BottomNavigationView
        navb.setOnItemSelectedListener {
            when(it.itemId)
            {
               R.id.all-> {
                   load(All())
                   true
               }
                R.id.Online-> {
                    load(Online())
                    true
                }
                R.id.offline-> {
                    load(Offline())
                    true
                }
               else->{
                   true}
            }
        }

        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




    }

    private fun load(fragment : Fragment){
      val  tra = supportFragmentManager.beginTransaction()
        tra.replace(R.id.container,fragment)
      tra.commit()
    }


}
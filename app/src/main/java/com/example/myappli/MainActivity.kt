package com.example.myappli

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.myappli.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



      /* binding.textlr.setOnClickListener()
        {
           if(binding.textlr.text.toString()=="Login")
           {
               binding.textlr.text="Register"
               replacefragment(Login())
           }
            else{
               binding.textlr.text = "Login"
               replacefragment(Register())
           }
        }*/



    }

    /*private fun replacefragment(frg: Fragment){
        val frgManager = supportFragmentManager
        val frgTransaction = frgManager.beginTransaction()

        frgTransaction.replace(R.id.cnt,frg)
        frgTransaction.commit()
    }*/




}
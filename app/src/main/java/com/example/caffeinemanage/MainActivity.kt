package com.example.caffeinemanage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    fun setCaffeine(mg: Int, cf_result: TextView){
        var cf_str = String.format("%d mg", mg)
        cf_result.text = cf_str
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentmanager = supportFragmentManager
        fragmentmanager.beginTransaction().add(R.id.fragment_frame, FirstFragment()).commit()

        val btnNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        btnNav.setOnNavigationItemSelectedListener{ item ->
            when(item.itemId) {
                R.id.page_1 -> {
                    fragmentmanager.beginTransaction().replace(R.id.fragment_frame, FirstFragment()).commit()
                    true
                }
                R.id.page_2 -> {
                    fragmentmanager.beginTransaction().replace(R.id.fragment_frame, SecondFragment()).commit()
                    true
                }
                R.id.page_3 -> {
                    // Respond to navigation item 2 click
                    true
                }
                R.id.page_4 -> {
                    fragmentmanager.beginTransaction().replace(R.id.fragment_frame, SettingFragment()).commit()
                    true
                }

                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
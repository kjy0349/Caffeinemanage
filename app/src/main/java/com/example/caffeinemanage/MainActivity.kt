package com.example.caffeinemanage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    fun setCaffeine(mg: Int, cf_result: TextView){
        var cf_str = String.format("%d mg", mg)
        cf_result.text = cf_str
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val leap = findViewById(R.id.leap) as ImageView

        Glide.with(this).load(R.raw.updownleap).override(1000, 1000).into(leap)


        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.page_1 -> {
                    // Respond to navigation item 1 click
                    true
                }
                R.id.page_2 -> {
                    // Respond to navigation item 2 click
                    true
                }
                R.id.page_3 -> {
                    // Respond to navigation item 2 click
                    true
                }
                R.id.page_3 -> {
                    // Respond to navigation item 2 click
                    true
                }

                else -> false
            }
        }
        BottomNavigationView.OnNavigationItemReselectedListener { item ->
            when(item.itemId) {
                R.id.page_1 -> {
                    // Respond to navigation item 1 reselection
                }
                R.id.page_2 -> {
                    // Respond to navigation item 1 reselection
                }
                R.id.page_3 -> {
                    // Respond to navigation item 1 reselection
                }
                R.id.page_4 -> {
                    // Respond to navigation item 1 reselection
                }
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
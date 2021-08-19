package com.example.caffeinemanage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.caffeinemanage.databinding.MainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val viewModel: CaffeineViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: MainBinding = DataBindingUtil.setContentView(this, R.layout.fragment_second)

        binding.also {
            it.lifecycleOwner = this
            it.viewModel = viewModel
        }
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
                    true
                }
                R.id.page_4 -> {
                    fragmentmanager.beginTransaction().replace(R.id.fragment_frame, SettingFragment()).commit()
                    true
                }

                else -> false
            }
        }

        if(intent.hasExtra("user_info")){
            val user_info = intent.getStringExtra("user_info")
            Toast.makeText(this,user_info,Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
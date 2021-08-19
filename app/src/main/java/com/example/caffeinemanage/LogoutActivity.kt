package com.example.caffeinemanage

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.firebase.ui.auth.AuthUI

class LogoutActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)
        AuthUI.getInstance()
            .signOut(this)
            .addOnCompleteListener {
                // ...
            }

    }
}
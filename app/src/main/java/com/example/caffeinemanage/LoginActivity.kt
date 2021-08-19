package com.example.caffeinemanage

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import kotlin.reflect.typeOf

class LoginActivity : AppCompatActivity(){
    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ){ res ->
        this.onSignInResult(res)
    }
    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult){
        val response = result.idpResponse
        if (result.resultCode == Activity.RESULT_OK){
            val user = FirebaseAuth.getInstance().currentUser.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user_info",user)
            startActivity(intent)
        } else {
            Toast.makeText(this, response?.error?.errorCode.toString(), Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // firebase Authentication

        // Choose authentication providers
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )

        // Create and launch sign-in intent
        val signinintent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .setLogo(R.drawable.coffee_seed)
            .setTheme(R.style.Theme_Caffeinemanage)
            .build()
        signInLauncher.launch(signinintent)

    }
}
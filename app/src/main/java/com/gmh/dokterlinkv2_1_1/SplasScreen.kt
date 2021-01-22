package com.gmh.dokterlinkv2_1_1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SplasScreen : AppCompatActivity()
{
    private var firebaseAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        firebaseAuth = FirebaseAuth.getInstance()

        Handler().postDelayed({
            firebaseAuth!!.currentUser?.let {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            startActivity(Intent(this, WelcomeActivity::class.java))
            finish()
        }, 4000)

    }
}
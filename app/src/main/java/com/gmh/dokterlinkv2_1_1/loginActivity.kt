package com.gmh.dokterlinkv2_1_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_login.*

class loginActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var refusers: DatabaseReference
    private var firebaseUserID: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()
        checkboxLogin.setOnClickListener {
            if (checkboxLogin.isChecked) {
                password_login.inputType = 1
            } else
                password_login.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_NUMBER_VARIATION_PASSWORD
            }


        btn_login.setOnClickListener {
            loginUser()
        }
    }

    private fun loginUser() {
        val email: String = email_login.text.toString()
        val password: String = password_login.text.toString()

        if (email == "")
        {
            Toast.makeText(this@loginActivity, "Tolong masukkan Email anda", Toast.LENGTH_LONG).show()
        }
        else if (password == "")
        {
            Toast.makeText(this@loginActivity, "Tolong masukkan Password anda",Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(this@loginActivity,"Loading...", Toast.LENGTH_SHORT).show()
            mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful)
                    {
                        val intent = Intent(this@loginActivity, MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        finish()
                    }
                    else
                    {
                        Toast.makeText(this@loginActivity, "Error Message: " + task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}
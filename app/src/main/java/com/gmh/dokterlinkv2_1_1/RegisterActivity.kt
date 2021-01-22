package com.gmh.dokterlinkv2_1_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var refUsers: DatabaseReference
    private var firebaseUserID: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        mAuth = FirebaseAuth.getInstance()

        btn_register.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser()
    {
        val username: String = username_register.text.toString()
        val email: String = email_register.text.toString()
        val alamat: String = alamat_register.text.toString()
        var pekerjaan: String = pekerjaan_register.text.toString()
        val password: String = password_register.text.toString()


        if (username == "")
        {
            Toast.makeText(this@RegisterActivity, "Lengkapi Username nya", Toast.LENGTH_LONG).show()
        }
        else if (email == "")
        {
            Toast.makeText(this@RegisterActivity, "Lengkapi email nya", Toast.LENGTH_LONG).show()
        }
        else if (password == "")
        {
            Toast.makeText(this@RegisterActivity, "Lengkapi password nya", Toast.LENGTH_LONG).show()
        }
        else if (alamat == "")
        {
            Toast.makeText(this@RegisterActivity, "Lengkapi alamat nya", Toast.LENGTH_LONG).show()
        }
        else if (pekerjaan == "")
        {
            Toast.makeText(this@RegisterActivity, "Lengkapi pekerjaa nya", Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(this@RegisterActivity, "Loading...", Toast.LENGTH_LONG).show()
            mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful)
                    {
                        firebaseUserID = mAuth.currentUser!!.uid
                        refUsers = FirebaseDatabase.getInstance().reference.child("Users").child(firebaseUserID)

                        val userHashMap = HashMap<String, Any>()
                        userHashMap["uid"] = firebaseUserID
                        userHashMap["username"] = username
                        userHashMap["alamat"] = alamat
                        userHashMap["pekerjaan"] = pekerjaan
                        userHashMap["profile"] = "https://firebasestorage.googleapis.com/v0/b/chatapp-3aa6b.appspot.com/o/null-photo.png?alt=media&token=ef8f3303-1764-4ae3-bc2d-e43c16a190e2"
                        userHashMap["cover"] = "https://firebasestorage.googleapis.com/v0/b/dokterlinkv2-1-1.appspot.com/o/KONSULEN_DL(revisi).jpg?alt=media&token=8582c555-29ea-4eeb-af6d-17bc9805cdc1"
                        userHashMap["status"] = "offline"
                        userHashMap["search"] = username.toLowerCase()

                        refUsers.updateChildren(userHashMap)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful)
                                {
                                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                                    startActivity(intent)
                                    finish()
                                }
                            }
                    }
                    else
                    {
                        Toast.makeText(this@RegisterActivity, "Error Message: " + task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
}
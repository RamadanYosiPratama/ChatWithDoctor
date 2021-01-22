package com.gmh.dokterlinkv2_1_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmh.dokterlinkv2_1_1.ModelClasses.Users
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_visit_user_profile.*

class VisitUserProfileActivity() : AppCompatActivity() {
    private var userVisitId: String = ""
    private val users: Users? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visit_user_profile)

        userVisitId = intent.getStringExtra("visit_id")!!

        val ref = FirebaseDatabase.getInstance().reference.child("Users").child(userVisitId)
        ref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists())
                {
                    val user = p0.getValue(Users::class.java)

                    username_display.text = user!!.getUsername()
                    category_docter.text = user!!.getCategoryy()
                    sip.text = user!!.getSipnumer()
                    tempat.text = user!!.getTempat()
                    anggota.text = user!!.getAnggota()
                    Picasso.get().load(user.getProfile()).into(profile_display)
                    Picasso.get().load(user.getCover()).into(cover_display)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })


//        send_konsul.setOnClickListener {
//            val intent = Intent(this@VisitUserProfileActivity, MessageChatActivity::class.java)
//            intent.putExtra("visit_id", users!!.getUID()!!)
//            startActivity(intent)
//        }

    }
}
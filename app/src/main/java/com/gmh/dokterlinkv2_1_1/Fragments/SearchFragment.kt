package com.gmh.dokterlinkv2_1_1.Fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmh.dokterlinkv2_1_1.AdapterClasses.UserAdapter
import com.gmh.dokterlinkv2_1_1.ModelClasses.Users
import com.gmh.dokterlinkv2_1_1.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SearchFragment : Fragment() {
    private var userAdapter: UserAdapter? = null
    private var mUsers: List<Users>? = null
    private var recyclerView: RecyclerView? = null
//    private var searchEditText: EditText? = null
    private lateinit var database: DatabaseReference
// ...

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_search, container, false)

        recyclerView = view.findViewById(R.id.searchList)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = LinearLayoutManager(context)
//        searchEditText = view.findViewById(R.id.searchUsersET)
        database = Firebase.database.reference


        mUsers = ArrayList()
        retrieveAllUsers()
//        searchForUsers()


//        searchEditText!!.addTextChangedListener(object : TextWatcher
//        {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(cs: CharSequence?, start: Int, before: Int, count: Int) {
//             searchForUsers()
//            }
//            override fun afterTextChanged(s: Editable?) {
//
//            }
//
//        })

        return view
    }

    private fun retrieveAllUsers()
    {
        var firebaseUserID = FirebaseAuth.getInstance().currentUser!!.uid
//        val getKerjaan = database.child("Users").orderByChild("Users/dokter")
//        val refUsers = FirebaseDatabase.getInstance().reference.child("Users")
        val refUsers = FirebaseDatabase.getInstance().reference.child("Users").orderByChild("pekerjaan")
            .startAt("dokter")
            .endAt( "dokter\uf8ff")
        refUsers.addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(p0: DataSnapshot)
            {
                (mUsers as ArrayList<Users>).clear()

                    for (snapshot in p0.children)
                    {
                        val user: Users? = snapshot.getValue(Users::class.java)
                        if (!(user!!.getUID()).equals(firebaseUserID))
                        {
                            (mUsers as ArrayList<Users>).add(user)
                        }
                    }
                    userAdapter =
                        UserAdapter(
                            context!!,
                            mUsers!!,
                            false
                        )
                    recyclerView!!.adapter = userAdapter

            }

            override fun onCancelled(p0: DatabaseError) {

            }


        })
    }
//
//    private fun searchForUsers()
//    {
//        var firebaseUserID = FirebaseAuth.getInstance().currentUser!!.uid
//
//        val queryUsers = FirebaseDatabase.getInstance().reference
//                .child("Users").orderByChild("pekerjaan")
//                .startAt("Cust")
//                .endAt("Cust\uf8ff")
//
//        queryUsers.addValueEventListener(object : ValueEventListener{
//            override fun onDataChange(p0: DataSnapshot)
//            {
//                (mUsers as ArrayList<Users>).clear()
//
//                for (snapshot in p0.children)
//                {
//                    val user: Users? = snapshot.getValue(Users::class.java)
//                    if (!(user!!.getUID().equals(firebaseUserID)))
//                    {
//                        (mUsers as ArrayList<Users>).add(user)
//                    }
//                }
//                userAdapter =
//                    UserAdapter(
//                        context!!,
//                        mUsers!!,
//                        false
//                    )
//                recyclerView!!.adapter = userAdapter
//            }
//            override fun onCancelled(error: DatabaseError) {
//
//            }
//
//        })
//    }


}
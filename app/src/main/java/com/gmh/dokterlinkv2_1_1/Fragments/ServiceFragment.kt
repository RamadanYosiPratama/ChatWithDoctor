package com.gmh.dokterlinkv2_1_1.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gmh.dokterlinkv2_1_1.ModelClasses.News
import com.gmh.dokterlinkv2_1_1.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_service.*


class ServiceFragment : Fragment() {

    lateinit var mRecyclerView: RecyclerView
    lateinit var mDatabase : DatabaseReference
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_service, container, false)

        mRecyclerView = view.findViewById(R.id.recycler_view_chatslistService)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(context)

        mDatabase = FirebaseDatabase.getInstance().getReference("Users")
//        logRecycle()
        return view
    }

//    private fun logRecycle() {
//        var FirebaseRecyclerAdapter = object : FirebaseRecyclerAdapter<News, NewsViewHolder>(
//
//        )
//    }

    class NewsViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!)
    {

    }

}
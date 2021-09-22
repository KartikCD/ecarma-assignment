package io.kartikcd.ecarmaassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.kartikcd.ecarmaassignment.adapter.CommunityListAdapter
import io.kartikcd.ecarmaassignment.models.Community

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_add_community)

//        val recyclerview = findViewById(R.id.recyclerview_community) as RecyclerView
//
//        val communities = listOf(
//            Community("Brigade Sympony", true),
//            Community("Community 2", false),
//            Community("Community 3", false),
//            Community("Community 4", false),
//            Community("Community 5", false)
//        )
//
//        val communityListAdapter = CommunityListAdapter()
//
//        recyclerview.layoutManager = LinearLayoutManager(applicationContext)
//        recyclerview.adapter = communityListAdapter
//
//        communityListAdapter.submitList(communities)
//
//        communityListAdapter.setOnCommunityClickListener {
//
//        }

    }
}
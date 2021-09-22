package io.kartikcd.ecarmaassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.kartikcd.ecarmaassignment.adapter.AssetListAdapter
import io.kartikcd.ecarmaassignment.adapter.CommunityListAdapter
import io.kartikcd.ecarmaassignment.models.Community

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_community_details)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview_assets)

        val communities = listOf(
            Community("Brigade Sympony", true),
            Community("Community 2", false),
            Community("Community 3", false),
            Community("Community 4", false),
            Community("Community 5", false)
        )

        println("Debug: ${recyclerview.toString()}")

        val assets = listOf(
            "Association",
            "Block details",
            "Manpower",
            "Assets",
            "Amenities",
            "AMC",
            "Documents"
        )

        val communityListAdapter = AssetListAdapter()

        recyclerview.layoutManager = LinearLayoutManager(applicationContext)
        recyclerview.adapter = communityListAdapter

        communityListAdapter.submitList(assets)

    }
}
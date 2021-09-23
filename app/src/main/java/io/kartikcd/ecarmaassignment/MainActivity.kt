package io.kartikcd.ecarmaassignment

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.kartikcd.ecarmaassignment.adapter.AssetListAdapter
import io.kartikcd.ecarmaassignment.adapter.AssociationListAdapter
import io.kartikcd.ecarmaassignment.adapter.CommunityListAdapter
import io.kartikcd.ecarmaassignment.databinding.ActivityMainBinding
import io.kartikcd.ecarmaassignment.models.Association
import io.kartikcd.ecarmaassignment.models.Community

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.main_host_fragment)
        val appBarConfiguration = AppBarConfiguration
            .Builder(R.id.splashFragment, R.id.registerFragment, R.id.loginFragment, R.id.main_feed_fragment)
            .build()

        setupActionBarWithNavController(navController, appBarConfiguration)

//        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview_associations)
//
//        val communities = listOf(
//            Community("Brigade Sympony", true),
//            Community("Community 2", false),
//            Community("Community 3", false),
//            Community("Community 4", false),
//            Community("Community 5", false)
//        )
//
//        val associations = listOf(
//            Association("President", "Rahul Raj", "Flat 314", "9987746997", "xyz@gmail.com"),
//            Association("Vice President", "Ankit Gupta", "Flat 318", "8116162777", "xyz@gmail.com")
//        )
//
//        println("Debug: ${recyclerview.toString()}")
//
//        val assets = listOf(
//            "Association",
//            "Block details",
//            "Manpower",
//            "Assets",
//            "Amenities",
//            "AMC",
//            "Documents"
//        )
//
//        val communityListAdapter = AssociationListAdapter()
//
//        recyclerview.layoutManager = LinearLayoutManager(applicationContext)
//        recyclerview.adapter = communityListAdapter
//
//        communityListAdapter.submitList(associations)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.main_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
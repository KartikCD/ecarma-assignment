package io.kartikcd.ecarmaassignment.ui.mainfeed

import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import io.kartikcd.ecarmaassignment.R
import io.kartikcd.ecarmaassignment.databinding.FragmentMainFeedBinding

class MainFeedFragment : Fragment() {

    private var _binding: FragmentMainFeedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            requireActivity().window.statusBarColor = ContextCompat.getColor(requireActivity(), R.color.colorPrimaryDark)
        }
//        val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.ic_back_arrow)
//        drawable?.setColorFilter(ContextCompat.getColor(requireContext(), R.color.black), PorterDuff.Mode.SRC_ATOP)
//        (activity as AppCompatActivity?)!!.supportActionBar?.setHomeAsUpIndicator(drawable)
        val appBarConfiguration = AppBarConfiguration
            .Builder(R.id.communityMainFragment)
            .build()

//        val appConfiguration = AppBarConfiguration(navController.graph)

        _binding = FragmentMainFeedBinding.inflate(layoutInflater, container, false)
        val navController = NavHostFragment.findNavController(this)
        (activity as AppCompatActivity?)!!.setupActionBarWithNavController(navController, appBarConfiguration)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainFeedBottomNavigation.setupWithNavController(Navigation.findNavController(
            requireActivity(), R.id.main_feed_bottom_navigation
        ))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}